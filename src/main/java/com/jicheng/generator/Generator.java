package com.jicheng.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Generator
 *
 * @author Jicheng Li
 * @version v1.0
 * @date 2021/10/8 18:17
 */
public class Generator {

    public static void main(String[] args) {
        try {
            Generator generator = new Generator();
            generator.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generator() throws Exception {
        // 执行过程中的警告信息
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        InputStream is = Generator.class.getResourceAsStream("/mybatis-generator-config.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration configuration = cp.parseConfiguration(is);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, callback, warnings);
        myBatisGenerator.generate(null);
        warnings.forEach(System.out::println);
    }
}
