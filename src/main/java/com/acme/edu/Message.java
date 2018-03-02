package com.acme.edu;

import static com.acme.edu.Message.Type.BYTE;

public class Message {
    private ByteMessage byteMessage;
    private Type type;
    enum Type {
        BYTE
    }
    public Type getType() {
        return type;
    }



    public Message(byte byteMessage) {
        setByteMessage(new ByteMessage(byteMessage));
    }

    private void setByteMessage(ByteMessage byteMessage) {
        this.byteMessage = byteMessage;
        this.type = BYTE;
    }

    public String getMessage() {
        switch (getType()) {
            case BYTE:
                return "primitive: " + String.valueOf(byteMessage.getByteMessage());
            default:
                return null;
        }
    }
}
