package com.acme.edu.messages;

import com.acme.edu.Controller;

import static com.acme.edu.Logger.flush;

public class StringMessage extends Message{
    private static final String PREFIX = "string: ";
    private Controller controller;

    public StringMessage(String stringMessage, Controller controller) {
        this.controller = controller;
        checkForSum();
        super.setPREFIX(PREFIX);
        super.setTypedMessage(stringMessage);
    }

    private void checkForSum(){
        if (controller.getSum() != 0) {
            flush();
        }

    }
}
