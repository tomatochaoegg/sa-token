package com.hankun.satokenlearn.util;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.hankun.satokenlearn.base.controller.BaseController;
import com.hankun.satokenlearn.base.model.BaseModel;
import com.hankun.satokenlearn.base.service.BaseService;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @Author hankun
 * @Description TODO
 * @Date 2021/6/4
 * @Version 1.0
 */
@Slf4j
public class AutoFile {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false";
        String username = "root";
        String password = "root";
        String driver = "com.mysql.cj.jdbc.Driver";
        String pack = "com.hankun.satokenlearn";
        String author = "hankun";
        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 2、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(author);
        gc.setOpen(false); //生成后是否打开资源管理器
        gc.setFileOverride(false); //重新生成时文件是否覆盖
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        //UserServie
        gc.setServiceName("%sService");	//去掉Service接口的首字母I

        gc.setIdType(IdType.ASSIGN_ID); //主键策略
        gc.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型
        gc.setSwagger2(true);//开启Swagger2模式

        // XML ResultMap: mapper.xml生成查询映射结果
        gc.setBaseResultMap(true);
        // XML ColumnList: mapper.xml生成查询结果列
        gc.setBaseColumnList(true);
        mpg.setGlobalConfig(gc);

        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setTypeConvert(new MySqlTypeConvert() {
            // 自定义数据库表字段类型转换【可选】
            @Override
            public IColumnType processTypeConvert(GlobalConfig gc, String fieldType) {
                System.out.println("转换类型：" + fieldType);
                // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                //默认会把日期类型 转为LocalDateTime ，在查询的时候会报错，这里改为Date
                String t = fieldType.toLowerCase();
                if (t.contains("date") || t.contains("time") || t.contains("year")) {
                    return DbColumnType.DATE;
                } else {
                    return super.processTypeConvert(gc, fieldType);
                }
            }
        });
        dsc.setUrl(url);
        dsc.setDriverName(driver);
        dsc.setUsername(username);
        dsc.setPassword(password);
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);
        //4、包配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName("eduservice"); //模块名
        //包  com.atguigu.eduservice
        pc.setParent(pack);
        //包  com.atguigu.eduservice.controller
        pc.setController("controller");
        pc.setXml("mapper.xml");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        //自定义生成文件
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };
        // xml输出文件配置
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/simple/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                log.info(tableInfo.getEntityName()+".xml生成！");
                // Mapper.xml 文件存放地址及文件名
                return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig().
                // 需要生成的表
//                        setInclude("access_log").
        setNaming(NamingStrategy.underline_to_camel).//数据库表映射到实体的命名策略
                setTablePrefix("sys_"). //生成实体时去掉表前缀

                setColumnNaming(NamingStrategy.underline_to_camel).//数据库表字段映射到实体的命名策略
                setEntityLombokModel(true). // lombok 模型 @Accessors(chain = true) setter链式操作
                setRestControllerStyle(true).
                // 驼峰转连字符
                        setControllerMappingHyphenStyle(true).
                        setRestControllerStyle(true). //restful api风格控制器
                setControllerMappingHyphenStyle(true).//url中驼峰转连字符
                setVersionFieldName("version").
                        setLogicDeleteFieldName("is_deleted").
                        setTableFillList(Arrays.asList(
                                new TableFill("update_time", FieldFill.UPDATE),
                                new TableFill("create_time", FieldFill.INSERT)));
        // 自定义实体父类
        strategy.setSuperEntityClass(BaseModel.class);
        // 自定义实体，公共字段
        strategy.setSuperEntityColumns(
                "create_by","create_date","update_by","update_date","del_flag","remark");
        // 自定义 mapper 父类
        strategy.setSuperMapperClass("com.baomidou.mybatisplus.core.mapper.BaseMapper");
        // 自定义 service 父类
        strategy.setSuperServiceImplClass(BaseService.class);
        // 自定义 controller 父类
        strategy.setSuperControllerClass(BaseController.class);

        mpg.setStrategy(strategy);

//        //6、自定义模板配置
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        TemplateConfig tc = new TemplateConfig();
        tc.setController("/simple/controller.java")
                .setService("/simple/service.java")
                .setServiceImpl("/simple/serviceImpl.java")
                .setEntity("/simple/entity.java")
                .setMapper("/simple/mapper.java")
                .setXml(null);
        mpg.setTemplate(tc);
        mpg.execute();
        System.out.println("代码生成完毕");

    }

}
