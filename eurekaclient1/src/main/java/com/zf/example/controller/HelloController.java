package com.zf.example.controller;

import com.zf.example.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ZHANGFEI on 2019/4/18.
 */
@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient discoveryClient;


    @RequestMapping(path = "/hello",method = RequestMethod.GET)
    public String hello(){

        List<String> services = discoveryClient.getServices();
        logger.info("services is : {}",services.toString());
        return "MY TEST HELLO WORLD!!!";
    }

    @RequestMapping(path = "/hello1",method = RequestMethod.GET)
    public String hello1(@RequestParam(name = "name") String name){
        return "Hello : " + name;
    }

    @RequestMapping(path = "/hello2",method = RequestMethod.GET)
    public User hello2(@RequestHeader String name, @RequestHeader Integer age){
        return new User(name,age);
    }

    @RequestMapping(path = "/hello3",method = RequestMethod.POST)
    public String hello3(@RequestBody User user){
        return "Hello "+user.getName()+ " , " + user.getAge();
    }
}
