package com.acme.OldLogger.messages;

public class ObjectMessage extends Message {
    private static final String PREFIX = "reference: ";

    public ObjectMessage(final Object objectMessage) {
        super.setPREFIX(PREFIX);
        super.setTypedMessage(objectMessage.toString());
    }
}
