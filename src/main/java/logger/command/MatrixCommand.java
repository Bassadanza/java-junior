package logger.command;

import logger.command.CommandUtils.ArrayFormatter;
import logger.formatter.Visitor;

public final class MatrixCommand extends ArrayFormatter implements Command {
  private int[][] matrixCommand;

  public MatrixCommand(final int[][] matrixCommand) {
    this.matrixCommand = matrixCommand;
  }

  @Override
  public boolean accumulate(final Command previousCommand) {
    return true;
  }

  @Override
  public void dontAccumulate() {

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
