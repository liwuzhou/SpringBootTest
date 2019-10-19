package com.lee.demo.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:test.yml")
@ConfigurationProperties(prefix = "lee")
public class SelfConfigInfo {

    private String testName1;

    private String testName2;

    private String testName3;

    public String getTestName1() {
        return testName1;
    }

    public void setTestName1(String testName1) {
        this.testName1 = testName1;
    }

    public String getTestName2() {
        return testName2;
    }

    public void setTestName2(String testName2) {
        this.testName2 = testName2;
    }

    public String getTestName3() {
        return testName3;
    }

    public void setTestName3(String testName3) {
        this.testName3 = testName3;
    }
}
