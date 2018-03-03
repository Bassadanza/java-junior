package com.acme.edu;

import com.acme.edu.designer.Designer;
import com.acme.edu.messages.Message;
import com.acme.edu.printer.ConsolePrinter;

public class Controller {
    private ConsolePrinter consolePrinter;
    private int sum = 0;

    public void setSum(final int sum) {
        this.sum += sum;
    }

    public int getSum() {
        return sum;
    }

    Controller(final ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    public void print(final Message message) {
        if (!message.isInteger()) {
            consolePrinter.print(new Designer(message).getFullMessage());
        }
    }
}
