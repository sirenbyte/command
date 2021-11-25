package com.example.command.service;

import com.example.command.config.SshProperties;
import com.example.command.enumr.CommandEnum;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Scanner;

@Service
@AllArgsConstructor
public class SshServiceImpl implements SshService {

    private final SshProperties sshProperties;

    private Session createSession() throws JSchException {
        try {
            JSch jSch = new JSch();
            Session session = jSch.getSession(sshProperties.getUsername(), sshProperties.getHost());
            session.setPassword(sshProperties.getPassword());
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            return session;
        } catch (JSchException e) {
            throw new JSchException(e.getMessage());
        }
    }

    private String getOutput(InputStream output) {
        Scanner s = new Scanner(new InputStreamReader(output)).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    public void runCommand(String command) {
        ChannelExec channel = null;
        try {
            Session session = createSession();

            channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand(CommandEnum.valueOf(command.toUpperCase()).getCommand());
            channel.setInputStream(null);
            InputStream output = channel.getInputStream();
            channel.connect();

            System.out.println(getOutput(output));
            channel.disconnect();

        } catch (JSchException | IOException e) {
            channel.disconnect();
            throw new RuntimeException(e.getMessage());
        }
    }
}