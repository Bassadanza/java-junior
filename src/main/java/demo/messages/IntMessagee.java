package demo.messages;

import demo.Controllerr;
import java.util.List;

public class IntMessagee implements Messagee {
    private int messagee;
    private Controllerr controlerr;
    private int sum;

    public Object getMessagee() {
        return messagee;
    }

    public void setMessagee(int messagee) {
        this.messagee = messagee;
    }

    public IntMessagee(Integer message, Controllerr controllerr) {
        setMessagee(message);
        this.controlerr = controllerr;
    }

    @Override
    public void accumulate() {
        List<Messagee> list = controlerr.getBuffer();
        int sum = 0;
        for (Messagee current : list) {
            sum += (Integer)current.getMessagee();
        }
        this.sum = sum;
    }

    @Override
    public Object decorate() {
        controlerr.bufferToNull();
        return sum;
    }
}
