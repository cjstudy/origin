package com.mini.mybatisplus.generator;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.mini.mybatisplus.base.BaseEntity;

import java.util.*;

public class MybatisPlusAutoGenerator {

    public static void main(String[] args) throws Exception {
        setSystemParams();
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        String projectName = scanner("项目名");
        Map<String, String> map = systemParams.get(projectName);
        if(map == null){
            throw new Exception("该项目不存在");
        }
        gc.setOutputDir(projectPath + map.get("modelName") + map.get("projectName") + "/src/main/java");
        gc.setAuthor("Jesse");
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        String dbName = map.get("dbName");
        if(dbName == null){
            dbName = scanner("数据库名称");
        }
        dsc.setUrl("jdbc:mysql://localhost:3306/" + dbName + "?useUnicode=true&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("tmob2019");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName(scanner("模块名"));
        String packageName = map.get("packageName");
        pc.setParent("com.babifood." + packageName);
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
//        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
         String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + map.get("modelName") + map.get("projectName") + "/src/main/resources/mapper/"
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
//         templateConfig.setEntity("entites/entity2.java");
//         templateConfig.setService("service/entity2.java");
//         templateConfig.setController("controller/entity2.java");

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass(BaseEntity.class);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
//        strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix("t_");
        mpg.setStrategy(strategy);
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }


    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    private static Map<String, Map<String, String>> systemParams = new HashMap<>();

    private static void setSystemParams(){
        Map<String, String> hrm = new HashMap<>();
        hrm.put("modelName", "/babi-enterprise");
        hrm.put("projectName", "/babi-hrm");
        hrm.put("dbName", "babi-hrm");
        hrm.put("packageName", "babihrm");
        systemParams.put("babi-hrm", hrm);

        Map<String, String> acc = new HashMap<>();
        acc.put("modelName", "/babi-mid");
        acc.put("projectName", "/babi-acc");
        acc.put("packageName", "babiacc");
        systemParams.put("babi-acc", acc);

        Map<String, String> cts = new HashMap<>();
        cts.put("modelName", "/babi-mid");
        cts.put("projectName", "/babi-cts");
        cts.put("packageName", "babicts");
        systemParams.put("babi-cts", cts);

        Map<String, String> emp = new HashMap<>();
        emp.put("modelName", "/babi-mid");
        emp.put("projectName", "/babi-emp");
        emp.put("dbName", "babi-emp");
        emp.put("packageName", "babiemp");
        systemParams.put("babi-emp", emp);

        Map<String, String> sm = new HashMap<>();
        sm.put("modelName", "/babi-mid");
        sm.put("projectName", "/babi-sm");
        sm.put("dbName", "babi-sm");
        sm.put("packageName", "babism");
        systemParams.put("babi-sm", sm);

        Map<String, String> order = new HashMap<>();
        order.put("modelName", "/babi-supply");
        order.put("projectName", "/babi-order");
        order.put("dbName", "babi-order");
        order.put("packageName", "babiorder");
        systemParams.put("babi-order", order);

        Map<String, String> state = new HashMap<>();
        state.put("modelName", "/babi-supply");
        state.put("projectName", "/babi-state");
        state.put("dbName", "babi-state");
        state.put("packageName", "babistate");
        systemParams.put("babi-state", state);
    }
}
