package com.lee.demo.controller;

import com.lee.demo.dao.ColRepository;
import com.lee.demo.entity.Col;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MongodbController {

    @Autowired
    ColRepository repository;

    @GetMapping("/mongodbTest")
    public String mongodbTest(){

        List<Col> colList = repository.findAll();

        //System.out.println(colList);

        for (Col col:colList) {

            System.out.println(col.toString());
        }
       // customerRepository.save(new Customer("Alice", "77"));
       // customerRepository.save(new Customer("Bob", "88"));

        return colList.toString();
    }

    @GetMapping("/mongodbTest1")
    public String mongodbTest1(){

        Col col = repository.findByAge(34);

        return col.toString();
    }
}
