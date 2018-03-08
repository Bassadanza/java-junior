package com.acme.OldLogger.messages;

public class CharMessage extends Message {
    private static final String PREFIX = "char: ";

    public CharMessage(final Character charMessage) {
        super.setPREFIX(PREFIX);
        super.setTypedMessage(charMessage.toString());
    }
}
