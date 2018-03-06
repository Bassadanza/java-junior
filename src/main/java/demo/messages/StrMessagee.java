package demo.messages;

import demo.Controllerr;

import java.util.List;

public class StrMessagee implements Messagee {
    private String message;
    private Controllerr controllerr;
    private String sum;
    private int sameStringCount = 0;

    public int getSameCounter() {
        return sameStringCount;
    }

    public StrMessagee(String message, Controllerr controllerr) {
        this.message = message;
        this.controllerr = controllerr;
    }

    @Override
    public Object getMessagee() {
        return message;
    }

    @Override
    public void accumulate() {
        if ((controllerr.getPreviousMessagee()) != null) {
            sameStringCount = controllerr.getPreviousMessagee().getSameCounter() + 1;
            if (!message.equals(controllerr.getPreviousMessagee().getMessagee())) {
                controllerr.flush();
            }
        } else {
            sameStringCount += 1;
        }
        sum = message;
        controllerr.setPreviousMessagee(this);
    }

    @Override
    public Object decorate() {
        if (sameStringCount > 1) {
            return sum + " (x" + sameStringCount + ")";
        } else {
            return sum;
        }
    }

    /*public boolean equals(Object object) {
        String buffer = (String) object;
        if (buffer.substring(0, message.length() - 1).compareTo(message) == 0) {
            return true;
        } else {
            return false;
        }
    }*/

    private String encode(List<Messagee> messagee) {
        StringBuffer dest = new StringBuffer();
        for (int i = 0; i < messagee.size(); i++) {
            int runLength = 1;
            while (i + 1 < messagee.size() && messagee.get(i).getMessagee().toString().equals(messagee.get(i + 1).getMessagee().toString())) {
                runLength++;
                i++;
            }
            dest.append(messagee.get(i).getMessagee().toString());
            if (runLength > 1) {
                dest.append(" (x" + runLength + ")");
            }
        }
        // controllerr.bufferToNull();
        return dest.toString();
    }
}
