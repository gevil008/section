package com.baizhi.controller;

import com.baizhi.entity.Section;
import com.baizhi.service.SectionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CaoYaFei
 * @since 2020-11-19
 */
@RestController
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @GetMapping("/sections")
    public Map showPage(@RequestParam(defaultValue = "1")Integer page,
                        @RequestParam(defaultValue = "5")Integer limit,
                        String search){
        Page<Section> page1 = new Page<>(page,limit);
        Page<Section> sectionPage = null;
        if (search != null){
            QueryWrapper<Section> queryWrapper = new QueryWrapper();
            queryWrapper.like("section_name",search)
                    .or().like("section_mobile",search)
                    .or().like("section_address",search);
            sectionPage = sectionService.page(page1,queryWrapper);
        } else {
            sectionPage = sectionService.page(page1);
        }
        long total = sectionPage.getTotal();
        List<Section> records = sectionPage.getRecords();

        System.err.println(total);
        Map map = new HashMap();
        map.put("data",records);
        map.put("count",total);
        map.put("code",0);

        return map;
    }

    @DeleteMapping("/sections/{id}")
    public Map deleteOne(@PathVariable("id")Integer id){
        System.err.println(id);
        Map map = new HashMap();
        try {
            sectionService.removeById(id);
            map.put("status","success");
        } catch (Exception e) {
            map.put("status","error");
            e.printStackTrace();
        }
        return map;
    }

    @PostMapping("/sections")
    public Map addOne(@RequestBody Section section){
        System.err.println(section);
        Map map = new HashMap();
        boolean save = sectionService.save(section);
        System.err.println(save);
        if (save){
            map.put("status","success");
        } else {
            map.put("status","error");
        }
        return map;
    }

    @DeleteMapping("/sections")
    public Map deleteMay(@RequestBody List<Integer> ids){
        ids.forEach(System.err::println);
        boolean b = sectionService.removeByIds(ids);
        Map map = new HashMap();
        if (b){
            map.put("status","success");
        } else {
            map.put("status","error");
        }
        return map;
    }

    @PutMapping("/sections")
    public Map updateOne(@RequestBody Section section){
        System.err.println(section);
        boolean b = sectionService.updateById(section);
        Map map = new HashMap();
        if (b){
            map.put("status","success");
        } else {
            map.put("status","error");
        }
        return map;
    }


}

