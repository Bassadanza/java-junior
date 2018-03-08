package Logger.messages;

import Logger.Controller;
import Logger.Designer.Visitor;

public final class IntCommand implements Command {
    private int intMessage;
    private Controller controller;
    private int intSum = 0;

    public IntCommand(final int intMessage,
                      final Controller controllerr) {
        this.intMessage = intMessage;
        this.controller = controllerr;
    }

    public Object getMessage() {
        return intMessage;
    }

    @Override
    public int getCounter() {
        return intSum;
    }

    @Override
    public void accumulate(final Command previousCommand) {
        havePreviousCommand(previousCommand);
        controller.setPreviousCommand(this);
    }

    private void havePreviousCommand(final Command previousCommand) {
        if (previousCommand != null) {
            if (controller.isTheSameType(this)) {
                isOverflow(previousCommand);
            } else {
                controller.flush();
                intSum = intMessage;
            }
        } else {
            intSum = intMessage;
        }
    }

    private void isOverflow(final Command previousMessagge) {
        if ((long) intMessage
                + previousMessagge.getCounter() > Integer.MAX_VALUE
                || (long) intMessage
                + previousMessagge.getCounter() < Integer.MIN_VALUE) {
            controller.flush();
            intSum = intMessage;
        } else {
            intSum = previousMessagge.getCounter() + intMessage;
        }
    }

    @Override
    public String acceptVisitor(final Visitor visitor) {
        return visitor.visitInt(this);
    }
}
