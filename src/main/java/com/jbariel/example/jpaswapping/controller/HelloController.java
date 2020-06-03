package com.jbariel.example.jpaswapping.controller;

import java.util.List;

import com.jbariel.example.jpaswapping.model.Hello;
import com.jbariel.example.jpaswapping.respository.HelloRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

    public HelloController() {
        super();
    }

    @Autowired
    HelloRepository helloRepo;

    @GetMapping("/coal-mine/canary")
    public String checkCanary() {
        return "Tweet";
    }

    @GetMapping("/")
    public List<Hello> getAllHello() {
        return helloRepo.findAll();
    }

    @GetMapping("/{name}")
    public Hello getHello(@PathVariable("name") final String name) {
        Hello sample = new Hello().withName(name);
        return helloRepo.findOne(Example.of(sample)).orElse(helloRepo.saveAndFlush(sample));
    }

    @PutMapping("/{name}")
    public Hello addHello(@PathVariable("name") final String name) {
        return helloRepo.saveAndFlush(new Hello().withName(name));
    }
}