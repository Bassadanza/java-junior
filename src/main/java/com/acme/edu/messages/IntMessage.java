package com.acme.edu.messages;

import com.acme.edu.Controller;

import static com.acme.edu.Logger.flush; //костыль

public class IntMessage extends Message {
    private Controller controller;

    public IntMessage(final Integer intMessage,final Controller controller) {
        this.controller = controller;
        super.setIsInteger(true);
        super.setPREFIX("");
        toSum(intMessage);
    }

    private void toSum(final Integer intMessage) {
        if (controller.getSum() + (long) intMessage > Integer.MAX_VALUE || controller.getSum() + (long) intMessage < Integer.MIN_VALUE) {
            flush(); //костыль
        }
        controller.setSum(intMessage);
    }
}
