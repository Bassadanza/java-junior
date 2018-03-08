package com.acme.OldLogger.messages;

import com.acme.OldLogger.Controller;

public class StringMessage extends Message {
    private static final String PREFIX = "string: ";
    private Controller controller;

    public StringMessage(String stringMessage, Controller controller) {
        this.controller = controller;
        checkForSum(stringMessage);
        super.setPREFIX(PREFIX);
    }

    private void checkForSum(String stringMessage) {
        if(stringMessage.equals(controller.getLastString())){
            controller.plusLastString();
        } else{

            controller.setLastString(stringMessage);
            super.setTypedMessage(stringMessage);
        }
        controller.setLastType("STRING");
    }
}
