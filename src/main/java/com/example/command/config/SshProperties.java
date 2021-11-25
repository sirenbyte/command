package com.example.command.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "ssh", ignoreUnknownFields = false)
@Getter
@Setter
public class SshProperties {
    private String username;
    private String host;
    private String password;
}

