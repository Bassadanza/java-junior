package demo;

import demo.messages.Messagee;
import demo.printer.ConsolePrinterr;
import demo.printer.Printerr;

import java.util.ArrayList;
import java.util.List;

public class Controllerr {
    private final Printerr printerr = new ConsolePrinterr();
    private ArrayList<Messagee> buffer = new ArrayList<>();

    public Messagee getPreviousMessagee() {
        return previousMessagee;
    }

    private Messagee previousMessagee = null;

    public List<Messagee> getBuffer() {
        return buffer;
    }

    public void bufferToNull() {
        buffer.clear();
    }

    public void addBuffer(Messagee messagee) {
        buffer.add(messagee);
        previousMessagee = messagee;
    }

    public void execute(Messagee messagee) {
        if (previousMessagee == null) {
            addBuffer(messagee);
        } else if (isTheSameType(messagee)) {
            messagee.decorate();
        } else {
            flush();
            addBuffer(messagee);
        }
    }

    private boolean isTheSameType(Messagee messagee) {
        return previousMessagee.getMessagee().getClass().equals(messagee.getMessagee().getClass());
    }

    public void flush() {
        if ((previousMessagee != null)) {
            previousMessagee.accumulate();
            printerr.print(previousMessagee.decorate());
            bufferToNull();
            previousMessagee = null;
        }
    }
}