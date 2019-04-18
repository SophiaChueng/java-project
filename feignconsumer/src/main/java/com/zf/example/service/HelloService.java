package com.zf.example.service;

import com.zf.example.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ZHANGFEI on 2019/4/18.
 */
@FeignClient(value = "hello-service")
public interface HelloService {

    @RequestMapping(path = "hello",method = RequestMethod.GET)
    String hello();

    @RequestMapping(path = "hello1",method = RequestMethod.GET)
    String hello1(@RequestParam("name") String name);

    @RequestMapping(path = "hello2",method = RequestMethod.GET)
    User hello2(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(path = "hello3",method = RequestMethod.POST)
    String hello3(@RequestBody User user);
}
