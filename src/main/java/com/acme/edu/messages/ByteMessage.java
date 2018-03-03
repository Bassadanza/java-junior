package com.acme.edu.messages;

public class ByteMessage extends Message {
    private static final String PREFIX = "primitive: ";

    public ByteMessage(final Byte byteMessage) {
        super.setPREFIX(PREFIX);
        super.setTypedMessage(byteMessage.toString());
    }
}
