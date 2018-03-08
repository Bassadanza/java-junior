package Logger.messages;

import Logger.Controller;
import Logger.Designer.Visitor;

public final class CharCommand implements Command {

    private Controller controller;
    private Character charMessage;
    private int sameStringCount;

    public CharCommand(final char charMessage, final Controller controller) {
        this.controller = controller;
        this.charMessage = charMessage;
    }

    @Override
    public void accumulate(final Command previousMessagee) {
        havePreviousCommand(previousMessagee);
        controller.setPreviousCommand(this);
    }

    private void havePreviousCommand(final Command previousCommand) {
        if (previousCommand != null) {
            if (controller.isTheSameType(this)) {
                areEquals(previousCommand);
            } else {
                controller.flush();
                sameStringCount = 1;
            }
        } else {
            sameStringCount = 1;
        }
    }

    private void areEquals(final Command previousCommand) {
        if (charMessage.equals(previousCommand.getMessage())) {
            sameStringCount = previousCommand.getCounter() + 1;
        } else {
            controller.flush();
            sameStringCount = 1;
        }
    }

    @Override
    public Object getMessage() {
        return charMessage;
    }

    @Override
    public int getCounter() {
        return sameStringCount;
    }

    @Override
    public String acceptVisitor(final Visitor visitor) {
        return visitor.visitChar(this);
    }
}
