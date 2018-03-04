package com.acme.Logger.messages;

import com.acme.Logger.Controller;


public class ByteMessage extends Message {
    private Controller controller;

    public ByteMessage(final Byte byteMessage, final Controller controller) {
        this.controller = controller;
        super.setNeedToSum(true);
        super.setPREFIX("");
        checkByte(byteMessage);
    }

    private void checkByte(final Byte byteMessage) {
        if (!controller.getLastType().equals("BYTE") && !controller.getLastType().equals("NOTHING") ||
                controller.getSum() + (int) byteMessage > Byte.MAX_VALUE ||
                controller.getSum() + (int) byteMessage < Byte.MIN_VALUE) {
            controller.flush();
        }
        controller.addToSum(byteMessage);
        controller.setLastType("BYTE");
    }
}
