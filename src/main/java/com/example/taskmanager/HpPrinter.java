package com.example.taskmanager;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HpPrinter implements Printer {

    @Override
    public void print(String message) {
        System.out.println("HP 印表機: " + message);
    }
}