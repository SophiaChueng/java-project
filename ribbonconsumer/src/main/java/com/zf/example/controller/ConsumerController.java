package com.zf.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ZHANGFEI on 2019/4/18.
 */
@RestController
public class ConsumerController {

    private final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(path = "/ribbon-consumer",method = RequestMethod.GET)
    public String test(){
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://hello-service/hello", String.class);
        return forEntity.getBody();
    }
}
