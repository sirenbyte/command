package com.example.command.controller;

import com.example.command.service.MainService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class TestController {

    private final MainService mainService;

    @GetMapping("/test/{command}")
    public void RunCommand(@PathVariable String command){
        mainService.RunCommand(command);
    }
}
