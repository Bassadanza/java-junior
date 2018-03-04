package com.acme.edu;

import com.acme.edu.designer.Designer;
import com.acme.edu.messages.Message;
import com.acme.edu.printer.ConsolePrinter;

public class Controller {
    private ConsolePrinter consolePrinter;
    private int sum = 0;
    private String lastType = "NOTHING";
    private String lastString = "";
    private int sameStringCount = 0;

    public int getSameStringCount() {
        return sameStringCount;
    }

    public void setLastString(String lastString) {
        this.lastString = lastString;
    }

    public String getLastString() {
        return lastString;
    }

    public void plusLastString() {
        this.sameStringCount += 1;
    }

    public void setToZeroStringCount(){
        this.sameStringCount = 0;
    }

    public String getLastType() {
        return lastType;
    }

    public void setLastType(String lastType) {
        this.lastType = lastType;
    }

    public int getSum() {
        return sum;
    }

    public void addToSum(int sum) {
        this.sum += sum;
    }

    Controller(final ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    public void print(final Message message) {
        if (!message.isNeedToSum()) {
            consolePrinter.print(new Designer(message).getFullMessage());
        }
    }

    public void flush() {
        consolePrinter.print(getSum());
        addToSum(-getSum());
    }
}
