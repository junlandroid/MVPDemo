package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class NoteDaoGenerator {


    public static final int version = 1;//数据库版本
    public static final String entityPackageName = "com.zhg.junl.db.entity";//实体类生成的包名
    public static final String entityClassName = "JunlBean";//生成实体类的类名
    public static final String daoPackageName = "com.zhg.junl.db.dao";//指定dao层模块的包
    //自动生成模板类生成的绝对路径，也就是你的model创建的session文件夹,也就是java_gen
    public static final String autoGenerateJavaPath = "D:\\CompanyProjects\\TestFiles\\MVPDemo\\greeendaodemo\\src\\main\\java-gen";

    public static void main(String[] args) throws Exception {

        Schema schema = new Schema(version, entityPackageName);
        schema.setDefaultJavaPackageDao(daoPackageName);//如果不指定 默认与entityPackageName一致
        Entity entity=schema.addEntity(entityClassName);
        entity.addIdProperty();//主键
        entity.addStringProperty("title");//表的地2列 列名
        entity.addStringProperty("content");//表的地3列 列名
        entity.addStringProperty("createTime");//表的地4列 列名
        entity.setClassNameDao("NoteDao");//设置dao类的名称
        entity.setJavaDoc("auto greenDao generate javaBean by xuan");
        entity.setTableName("tb_note");//设置表名,默认是entityClassName(NOTE)的大写形式
        //自动生成java模板类
        new DaoGenerator().generateAll(schema,autoGenerateJavaPath);
    }


}
