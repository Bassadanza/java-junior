package Logger.messages;

import Logger.Controller;
import Logger.Designer.Visitor;

/**
 * Аккумулирование входных команд типа (@Link String)
 */
public final class StringCommand implements Command {
    /* Текущее сообщение */
    private String stringMessage;
    /* Счётчик схожих сообщений, по умолчанию 0 */
    private int sameStringCount = 0;
    private Controller controller;


    public int getCounter() {
        return sameStringCount;
    }

    public StringCommand(final String command,
                         final Controller controllerr) {
        this.stringMessage = command;
        this.controller = controllerr;
    }

    @Override
    public Object getMessage() {
        return stringMessage;
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
        if (stringMessage.equals(previousCommand.getMessage())) {
            sameStringCount = previousCommand.getCounter() + 1;
        } else {
            controller.flush();
            sameStringCount = 1;
        }
    }

    @Override
    public String acceptVisitor(final Visitor visitor) {
        return visitor.visitString(this);
    }
}
