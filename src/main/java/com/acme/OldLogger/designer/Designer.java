package com.acme.OldLogger.designer;

import com.acme.OldLogger.messages.Message;

public class Designer {
    private Message message;

    public Designer(final Message message) {
        this.message = message;
    }

    public String getFullMessage() {
        return message.getPREFIX() + message.getTypedMessage();
    }

}
