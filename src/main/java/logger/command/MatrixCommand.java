package logger.command;

import logger.Controller;
import logger.command.CommandUtils.ArrayFormatter;
import logger.formatter.Visitor;

public final class MatrixCommand extends ArrayFormatter implements Command {
  private Controller controller;
  private int[][] matrixCommand;

  public MatrixCommand(final int[][] matrixCommand,
                       final Controller controller) {
    this.controller = controller;
    this.matrixCommand = matrixCommand;
  }

  @Override
  public void accumulate(final Command previousCommand) {
  }

  @Override
  public void dontAccamulate() {

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

  @Override
  public String decorate() {
    StringBuilder strBuff = new StringBuilder();
    strBuff.append("{").append(System.getProperty("line.separator"));
    for (int[] firstLevelArray : (int[][]) getMessage()) {
      strBuff.append(decorate(firstLevelArray))
          .append(System.getProperty("line.separator"));
    }
    strBuff.append("}");
    return String.valueOf(strBuff);
  }
}
