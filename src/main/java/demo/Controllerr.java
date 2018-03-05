package demo;

import demo.messages.Messagee;
import demo.printer.ConsolePrinterr;
import demo.printer.Printerr;

import java.util.ArrayList;

public class Controllerr {
    private final Printerr printerr = new ConsolePrinterr();
    private ArrayList list = new ArrayList();

    public ArrayList getList() {
        return list;
    }

    public void setBuffer(Object object) {
            list.add(object);
    }

    public void execute(Messagee messagee) {
        if (messagee.accumulate()) {
            printerr.print(messagee.decorate());
        }
    }
    public void flush(){
        if (!list.isEmpty()) {

        }
    }
}
