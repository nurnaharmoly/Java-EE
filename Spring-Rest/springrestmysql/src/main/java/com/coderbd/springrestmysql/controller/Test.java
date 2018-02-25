package com.coderbd.springrestmysql.controller;

import com.coderbd.springrestmysql.domain.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Test {
    private final String temaple="Hello %s";
    private final AtomicLong automicLong=new AtomicLong();

@RequestMapping("/std")
    public Student getStudent(@RequestParam(value = "name", defaultValue = "World")String name, @RequestParam(value = "country", defaultValue = "BD") String country){
        return new Student(automicLong.incrementAndGet(), String.format(temaple, name),country);
    }
}
