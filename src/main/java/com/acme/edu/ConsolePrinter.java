package com.acme.edu;

public class ConsolePrinter implements Printer {


    @Override
    public void print(Message message) {
        System.out.println(message.getMessage());
    }
}
