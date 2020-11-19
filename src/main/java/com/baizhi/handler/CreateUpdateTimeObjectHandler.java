package com.baizhi.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CreateUpdateTimeObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        if(metaObject.hasGetter("createTime") && metaObject.getValue("createTime") == null){
            this.strictInsertFill(metaObject,"createTime", Date.class,new Date());
        }
        if(metaObject.hasGetter("updateTime") && metaObject.getValue("updateTime") == null){
            this.strictInsertFill(metaObject,"updateTime",Date.class,new Date());
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if(metaObject.hasGetter("updateTime") && metaObject.getValue("updateTime") == null){
            this.strictUpdateFill(metaObject,"updateTime",Date.class,new Date());
        }
    }
}
