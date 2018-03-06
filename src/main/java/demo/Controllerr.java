package demo;

import demo.messages.Messagee;
import demo.printer.Printerr;

public class Controllerr {
    private Printerr printerr;
    private Messagee previousMessagee = null;

    public Controllerr(Printerr printerr) {
        this.printerr = printerr;
    }

    public void setPreviousMessagee(Messagee previousMessagee) {
        this.previousMessagee = previousMessagee;
    }

    public Messagee getPreviousMessagee() {
        return previousMessagee;
    }

    public void execute(Messagee messagee) {
        if (previousMessagee == null) {
            messagee.accumulate();
        } else if (isTheSameType(messagee)) {
            messagee.accumulate();
        } else {
            flush();
        }
    }

    private boolean isTheSameType(Messagee messagee) {
        return previousMessagee.getMessagee().getClass().equals(messagee.getMessagee().getClass());
    }

    public void flush() {
        printerr.print(previousMessagee.decorate());
    }
}