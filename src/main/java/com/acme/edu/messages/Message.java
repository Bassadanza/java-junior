package com.acme.edu.messages;

public class Message {
    private String typedMessage;
    private String PREFIX;
    private boolean needToSum = false;

    public boolean isNeedToSum() {
        return needToSum;
    }

    void setNeedToSum(final boolean need) {
        needToSum = need;
    }

    public String getPREFIX() {
        return PREFIX;
    }

    void setPREFIX(final String PREFIX) {
        this.PREFIX = PREFIX;
    }

    public String getTypedMessage() {
        return typedMessage;
    }

    void setTypedMessage(final String typedMessage) {
        this.typedMessage = typedMessage;
    }
}
