package com.zf.example.controller;

import com.zf.example.entity.User;
import com.zf.example.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZHANGFEI on 2019/4/18.
 */
@RestController
public class FeignConsumerController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(path = "/feign-consumer",method = RequestMethod.GET)
    public String helloConsumer(){
        return helloService.hello();
    }

    @RequestMapping(path = "/feign-consumer2",method = RequestMethod.GET)
    public String helloConsumer2(){

        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\r\n")
                .append(helloService.hello1("TOM")).append("\r\n")
                .append(helloService.hello2("JACK",21)).append("\r\n")
                .append(helloService.hello3(new User("LUCY",33))).append("\r\n");

        return sb.toString();
    }
}
