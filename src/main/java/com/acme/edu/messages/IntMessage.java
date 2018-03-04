package com.acme.edu.messages;

import com.acme.edu.Controller;

public class IntMessage extends Message {
    private Controller controller;

    public IntMessage(final Integer intMessage,final Controller controller) {
        this.controller = controller;
        super.setNeedToSum(true);
        super.setPREFIX("");
        checkSum(intMessage);
    }

    private void checkSum(final Integer intMessage) {
        if (!controller.getLastType().equals("INTEGER")  && !controller.getLastType().equals("NOTHING")  ||
                controller.getSum() + (long) intMessage > Integer.MAX_VALUE ||
                controller.getSum() + (long) intMessage < Integer.MIN_VALUE) {
            controller.flush();
        }
        controller.addToSum(intMessage);
        controller.setLastType("INTEGER");
    }
}