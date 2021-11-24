package com.example.command.enumr;

import lombok.Getter;

@Getter
public enum CommandEnum {

    RESTART("systemctl restart nginx"),
    STATUS("systemctl status nginx");

    String command;

    CommandEnum(String command) {
        this.command = command;
    }
}
