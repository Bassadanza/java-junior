package com.acme.edu;

public class ByteMessage{
    private byte byteMessage;

    public byte getByteMessage() {
        return byteMessage;
    }

    public void setByteMessage(byte byteMessage) {
        this.byteMessage = byteMessage;
    }

    public ByteMessage(byte byteMessage) {
        setByteMessage(byteMessage);
    }
}
