package com.coderbd.springrestmysql.controller;

import com.coderbd.springrestmysql.domain.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class StudentController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/student")
    public Student greeting(@RequestParam(value="name", defaultValue="World") String name, @RequestParam(value="name", defaultValue="BD") String country) {
        return new Student(counter.incrementAndGet(),
                String.format(template, name),country);
    }
}
