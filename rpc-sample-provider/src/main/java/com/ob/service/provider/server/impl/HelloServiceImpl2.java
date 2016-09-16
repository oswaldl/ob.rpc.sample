package com.ob.service.provider.server.impl;

import com.ob.service.api.HelloService;
import com.ob.service.api.Person;
import com.ob.rpc.server.RpcService;

@RpcService(value = HelloService.class, version = "sample.hello2")
public class HelloServiceImpl2 implements HelloService {

    public String hello(String name) {
        return "你好! " + name;
    }

    public String hello(Person person) {
        return "你好! " + person.getFirstName() + " " + person.getLastName();
    }
}
