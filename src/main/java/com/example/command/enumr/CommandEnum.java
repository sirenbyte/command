package com.example.command.enumr;

import lombok.Getter;

@Getter
public enum CommandEnum {

    RESTART("sudo systemctl restart nginx"),
    STATUS("sudo systemctl status nginx");

    String command;

    CommandEnum(String command) {
        this.command = command;
    }
}
