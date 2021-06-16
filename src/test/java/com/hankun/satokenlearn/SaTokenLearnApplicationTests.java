package com.hankun.satokenlearn;

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
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@Slf4j
class SaTokenLearnApplicationTests {

    @Test
    void contextLoads() { // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("hankun");
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
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setTypeConvert(new MySqlTypeConvert() {
//            // 自定义数据库表字段类型转换【可选】
//            @Override
//            public IColumnType processTypeConvert(GlobalConfig gc, String fieldType) {
//                System.out.println("转换类型：" + fieldType);
//                // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
//                //默认会把日期类型 转为LocalDateTime ，在查询的时候会报错，这里改为Date
//                String t = fieldType.toLowerCase();
//                if (t.contains("date") || t.contains("time") || t.contains("year")) {
//                    return DbColumnType.DATE;
//                } else {
//                    return super.processTypeConvert(gc, fieldType);
//                }
//            }
//        });
        dsc.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 4、包配置
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName("eduservice"); //模块名
        //包  com.atguigu.eduservice
        pc.setParent("com.hankun.satokenlearn");
        //包  com.atguigu.eduservice.controller
        pc.setController("controller");
        pc.setXml("mapper.xml");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // TODO 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // xml输出文件配置
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // Mapper.xml 文件存放地址及文件名
                return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        //自定义生成文件
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig().
                // 需要生成的表
//                        setInclude("access_log").
        setNaming(NamingStrategy.underline_to_camel).//数据库表映射到实体的命名策略
                setTablePrefix("sys_"). //生成实体时去掉表前缀
                setColumnNaming(NamingStrategy.underline_to_camel).//数据库表字段映射到实体的命名策略
                setEntityLombokModel(true). // lombok 模型 @Accessors(chain = true) setter链式操作
                // 驼峰转连字符
                        setControllerMappingHyphenStyle(true).
                        setRestControllerStyle(true). //restful api风格控制器
                setControllerMappingHyphenStyle(true).//url中驼峰转连字符
                setVersionFieldName("version").
                        setLogicDeleteFieldName("is_deleted").
                        setTableFillList(Arrays.asList(
                                new TableFill("update_time", FieldFill.UPDATE),
                                new TableFill("create_time", FieldFill.INSERT)));

        // strategy.setExclude(new String[]{"test"}); // 排除生成的表
        // 自定义实体父类
        strategy.setSuperEntityClass(BaseModel.class);
        // 自定义实体，公共字段
         strategy.setSuperEntityColumns("create_by","create_date","update_by","update_date","del_flag","remark");
        // 自定义 mapper 父类
        //strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        strategy.setSuperServiceImplClass(BaseService.class);
        // 自定义 controller 父类
        strategy.setSuperControllerClass(BaseController.class);
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuilderModel(true);

        mpg.setStrategy(strategy);


        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                Map<String, Object> map = new HashMap<String, Object>();
//                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
//                this.setMap(map);
//            }
//        };
//
//        // 自定义 xxList.jsp 生成
//        List<FileOutConfig> focList = new ArrayList<>();
//        focList.add(new FileOutConfig("/template/list.jsp.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
//                return "D://my_" + tableInfo.getEntityName() + ".jsp";
//            }
//        });
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);
//
//        // 调整 xml 生成目录演示
//        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                return "/develop/code/xml/" + tableInfo.getEntityName() + ".xml";
//            }
//        });
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);
//
//        // 关闭默认 xml 生成，调整生成 至 根目录
//        TemplateConfig tc = new TemplateConfig();
//        tc.setXml(null);
//        mpg.setTemplate(tc);

        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
        // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        // TemplateConfig tc = new TemplateConfig();
        // tc.setController("...");
        // tc.setEntity("...");
        // tc.setMapper("...");
        // tc.setXml("...");
        // tc.setService("...");
        // tc.setServiceImpl("...");
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
        // mpg.setTemplate(tc);

        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        // 6、执行
        mpg.execute();
    }


}
