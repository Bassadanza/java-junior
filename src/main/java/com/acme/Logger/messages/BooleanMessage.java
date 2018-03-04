package com.acme.Logger.messages;

public class BooleanMessage extends Message {
    private static final String PREFIX = "primitive: ";

    public BooleanMessage(final Boolean booleanMessage) {
        super.setPREFIX(PREFIX);
        super.setTypedMessage(booleanMessage.toString());
    }
}
