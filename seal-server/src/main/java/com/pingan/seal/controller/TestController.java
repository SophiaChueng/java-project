package com.pingan.seal.controller;

import com.pingan.seal.entity.Person;
import com.pingan.seal.mapper.PersonMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试接口")
@RestController
@RequestMapping(path = "/test/")
public class TestController {

    @Autowired
    PersonMapper personMapper;

    @ApiOperation(value = "这是一个测试接口")
    @GetMapping(value = "/test1")
    public void test(){
        Person person = new Person();
        person.setName("jack");
        personMapper.insert(person);

    }
}
