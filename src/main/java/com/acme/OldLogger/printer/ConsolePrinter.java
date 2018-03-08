package com.acme.OldLogger.printer;

public class ConsolePrinter implements Printer {

    @Override
    public void print(final Object message) {
        System.out.println(message.toString());
    }
}
