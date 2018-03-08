package Logger.messages;

import Logger.Controller;
import Logger.Designer.Visitor;

public final class ArrayCommand implements Command {
    private int[] arrayCommand;
    private Controller controller;

    public ArrayCommand(final int[] arrayCommand, final Controller controller) {
        this.arrayCommand = arrayCommand;
        this.controller = controller;
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
        return arrayCommand;
    }

    /**
     * Суммирование сообщений типа (@code int[]) не предусмотрено
     * @return
     */
    @Override
    public int getCounter() {
        return 42;
    }

    @Override
    public String acceptVisitor(final Visitor visitor) {
        return visitor.visitArray(this);
    }
}
