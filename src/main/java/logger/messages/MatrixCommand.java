package Logger.messages;

import Logger.Controller;
import Logger.Designer.Visitor;

public final class MatrixCommand implements Command {
    private Controller controller;
    private int[][] matrixCommand;

    public MatrixCommand(final int[][] matrixCommand,
                         final Controller controller) {
        this.controller = controller;
        this.matrixCommand = matrixCommand;
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
        return matrixCommand;
    }

    /**
     * Суммирование матриц не предусмотрено
     */
    @Override
    public int getCounter() {
        return 42;
    }

    @Override
    public String acceptVisitor(final Visitor visitor) {
        return visitor.visitMatrix(this);
    }
}
