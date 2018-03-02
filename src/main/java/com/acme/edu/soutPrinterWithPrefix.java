package com.acme.edu;

public class soutPrinterWithPrefix implements Printer {
    private String prefix;
    private Object[] message;

    public soutPrinterWithPrefix(String prefix, Message massage) {
        setPrefix(prefix);
        setMessage(massage.getMessage());
    }

    private Object[] getMessage() {
        return message;
    }

    private void setMessage(Object[] message) {
        this.message = message;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    @Override
    public void print() {
        System.out.println(getPrefix()+ getMessage().toString());
    }
}
