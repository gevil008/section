package com.baizhi;


import com.baizhi.entity.Section;
import com.baizhi.mapper.SectionMapper;
import com.baizhi.service.SectionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SectionApplication.class)
public class SectionApplicationTests {

    @Autowired
    private SectionMapper sectionMapper;

    @Autowired
    private SectionService sectionService;

    @Test
    public void selectAll() {
        List<Section> sections = sectionMapper.selectList(null);
        sections.forEach(System.err::println);
    }

    @Test
    public void serviceSelectAll(){
        List<Section> list = sectionService.list();
        list.forEach(System.err::println);
    }

    @Test
    public void MapperPage(){
        Page<Section> page = new Page<>(1,4);
        QueryWrapper<Section> queryWrapper = new QueryWrapper<>();
        Page<Section> sectionPage = sectionMapper.selectPage(page, queryWrapper);
        List<Section> records = sectionPage.getRecords();
        records.forEach(System.err::println);
    }
    @Test
    public void ServicePage(){
        Page<Section> page = new Page<>(1,5);
        Page<Section> sectionPage = sectionService.page(page);
        List<Section> records = sectionPage.getRecords();
        records.forEach(System.err::println);
        System.out.println("Hello World");
    }

}
