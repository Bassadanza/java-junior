package demo.messages;

import demo.Controllerr;

public class IntMessagee implements Messagee{
    private int messagee;
    private Controllerr controlerr;

    public int getMessagee() {
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
    public boolean accumulate() {
        if (!(controlerr.getList().get(controlerr.getList().size()) instanceof Integer)){
            //flush();
        }
        controlerr.setBuffer(getMessagee());
        return true;
    }

    @Override
    public Object decorate() {
        return null;
    }
}
