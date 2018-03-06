package demo.messages;

import demo.Controllerr;

public class IntMessagee implements Messagee {
    private int messagee;
    private Controllerr controlerr;
    private int sum = 0;

    public Object getMessagee() {
        return messagee;
    }

    public IntMessagee(Integer message, Controllerr controllerr) {
        this.messagee = message;
        this.controlerr = controllerr;
    }

    @Override
    public void accumulate() {
        sum += messagee;
        controlerr.setPreviousMessagee(this);
    }

    @Override
    public Object decorate() {
        return getSameCounter();
    }

    @Override
    public int getSameCounter() {
        return sum;
    }
}
