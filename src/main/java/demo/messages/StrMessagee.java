package demo.messages;

import demo.Controllerr;
import java.util.List;

public class StrMessagee implements Messagee {
    private String message;
    private Controllerr controllerr;
    private String sum;

    public StrMessagee(String message, Controllerr controllerr) {
        this.message = message;
        this.controllerr = controllerr;
    }

    @Override
    public Object getMessagee() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void accumulate() {
        if(!(controllerr.getPreviousMessagee().getMessagee().equals(this.getMessagee()))){
            controllerr.flush();
        }
        controllerr.addBuffer(this);
    }

    @Override
    public Object decorate() {
        this.sum = encode(controllerr.getBuffer());
        controllerr.bufferToNull();
        return sum;

    }

    private String encode(List<Messagee> messagee) {
        StringBuffer dest = new StringBuffer();
        for (int i = 0; i < messagee.size(); i++) {
            int runLength = 1;
            while (i + 1 < messagee.size() && messagee.get(i).getMessagee().toString().equals(messagee.get(i + 1).getMessagee().toString())) {
                runLength++;
                i++;
            }
            dest.append(messagee.get(i).getMessagee().toString());
            if(runLength > 1){
                dest.append(" (x" + runLength + ")");
            }
        }
        controllerr.bufferToNull();
        return dest.toString();
    }
}
