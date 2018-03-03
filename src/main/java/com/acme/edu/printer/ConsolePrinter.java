package com.acme.edu.printer;

public class ConsolePrinter implements Printer {


    @Override
    public void print(final String message) {
        System.out.println(message);
    }

}
