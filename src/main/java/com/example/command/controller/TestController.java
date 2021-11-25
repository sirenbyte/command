package com.example.command.controller;

import com.example.command.service.SshService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class TestController {

    private final SshService sshService;

    @PostMapping("/test")
    public void RunCommand(@RequestBody String command) {
        sshService.runCommand(command);
    }
}
