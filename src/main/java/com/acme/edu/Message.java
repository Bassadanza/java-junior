package com.acme.edu;

public class Message {
    private T[] message;

    public Message(byte message) {
      //  setMessage(message);
    }

    public T[] getMessage() {
        return message;
    }

    public void setMessage(T[] message) {
        this.message = message;
    }

    public Message(T[] message){
        setMessage(message);
    }
}
