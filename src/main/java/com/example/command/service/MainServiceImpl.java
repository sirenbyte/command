package com.example.command.service;

import com.example.command.enumr.CommandEnum;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

@Service
public class MainServiceImpl implements MainService {

    @Override
    public void RunCommand(String command) {
        Process process;
        {
            try {
                process = Runtime.getRuntime().exec(CommandEnum.valueOf(command.toUpperCase(Locale.ROOT)).getCommand());
                process.waitFor();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
