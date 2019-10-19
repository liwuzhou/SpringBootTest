package com.lee.demo.entity;

import org.springframework.data.annotation.Id;

/**
 * mongodb测试用实体类
 */
public class Col {

    @Id
    public String id;

    public String name;

    public String age;

    public Col(){}

    public Col(String name,String age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Col{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
