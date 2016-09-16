package com.ob.service.provider.server.impl;

import com.ob.service.api.HelloService;
import com.ob.service.api.Person;
import com.ob.rpc.server.RpcService;

@RpcService(HelloService.class)
public class HelloServiceImpl implements HelloService {

    public String hello(String name) {
        if("oswaldl".equalsIgnoreCase(name)){
            return "i am working bill, don't bother me";
        }else if("bill".equalsIgnoreCase(name)){
            return "free to work, free to play!";
        }else {
            return "Hello! " + name;
        }
    }

    public String hello(Person person) {
        return "Hello! " + person.getFirstName() + " " + person.getLastName();
    }
}
