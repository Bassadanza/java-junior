package com.acme.edu.messages;

public class Message {
    private String typedMessage;
    private String PREFIX;
    private boolean isInteger;

    public boolean isInteger() {
        return isInteger;
    }

    public void setIsInteger(final boolean integer) {
        isInteger = integer;
    }

    public String getPREFIX() {
        return PREFIX;
    }

    public void setPREFIX(final String PREFIX) {
        this.PREFIX = PREFIX;
    }

    public String getTypedMessage() {
        return typedMessage;
    }

    protected void setTypedMessage(final String typedMessage) {
        this.typedMessage = typedMessage;
    }
}
