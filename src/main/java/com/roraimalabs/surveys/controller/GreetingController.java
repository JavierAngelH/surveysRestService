package com.roraimalabs.surveys.controller;

import java.util.concurrent.atomic.AtomicLong;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roraimalabs.surveys.domain.Greeting;

@RestController
public class GreetingController {
	
	@Autowired
	DataSource datasource;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(this.counter.incrementAndGet(),
                            String.format(template, name));
    }
}
