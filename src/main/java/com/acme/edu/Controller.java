package com.acme.edu;

public class Controller {
    private ConsolePrinter consolePrinter;

    public ConsolePrinter getConsolePrinter() {
        return consolePrinter;
    }

    private void setConsolePrinter(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    Controller(ConsolePrinter consolePrinter) {
        setConsolePrinter(consolePrinter);
    }

    public void print(Message message){
            consolePrinter.print(message);
    }
}
