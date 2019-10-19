package com.lee.demo.dao;

import com.lee.demo.entity.Col;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ColRepository extends MongoRepository<Col,String> {
    
    public Col findByAge(int name);
}
