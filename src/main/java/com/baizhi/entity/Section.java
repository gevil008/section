package com.baizhi.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author CaoYaFei
 * @since 2020-11-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_section")
public class Section implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "section_id", type = IdType.AUTO)
    private Integer sectionId;

    private String sectionName;

    private String sectionMobile;

    private String sectionAddress;

    @TableLogic
    private Integer deleted;

    @Version
    private Integer version;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
