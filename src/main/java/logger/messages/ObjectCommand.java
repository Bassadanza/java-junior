package Logger.messages;

import Logger.Controller;
import Logger.Designer.Visitor;

public final class ObjectCommand implements Command {
    private Controller controller;
    private Object objectMessage;

    public ObjectCommand(final Object objectMessage,
                         final Controller controller) {
        this.controller = controller;
        this.objectMessage = objectMessage;
    }

    @Override
    public void accumulate(final Command command) {
        if (command != null) {
            controller.flush();
        }
        controller.setPreviousCommand(this);
    }

    @Override
    public Object getMessage() {
        return objectMessage;
    }

    /**
     * Метод не используется для данного типа данных
     */
    @Override
    public int getCounter() {
        return 0;
    }

    @Override
    public String acceptVisitor(final Visitor visitor) {
        return visitor.visitObject(this);
    }
}
