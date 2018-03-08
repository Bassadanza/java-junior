package Logger.messages;

import Logger.Controller;
import Logger.Designer.Visitor;

/**
 * Вывод многомерных массивов не реализован
 */
public final class MultyArrayCommand implements Command {
    private Controller controller;
    private int[][][][] multydimArrayCommand;

    @Override
    public void accumulate(final Command command) {

    }

    @Override
    public Object getMessage() {
        return multydimArrayCommand;
    }

    @Override
    public int getCounter() {
        return 42;
    }

    @Override
    public String acceptVisitor(final Visitor visitor) {
        return visitor.visitMultydimArray(this);
    }
}
