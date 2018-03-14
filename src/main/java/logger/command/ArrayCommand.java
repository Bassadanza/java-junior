package logger.command;

import logger.command.CommandUtils.ArrayFormatter;
import logger.formatter.Visitor;

public final class ArrayCommand extends ArrayFormatter implements Command {
  private final int[] arrayCommand;

  public ArrayCommand(final int[] arrayCommand) {
    this.arrayCommand = arrayCommand;
  }

  /**
   * Суммирование сообщений типа (@code int[]) не предусмотрено.
   */
  @Override
  public int getCounter() {
    return 42;
  }

  @Override
  public Object getMessage() {
    return arrayCommand;
  }

  @Override
  public boolean accumulate(final Command previousCommand) {
    return true;
  }

  @Override
  public void notAccumulated() {
  }

  @Override
  public String decorate() {
    return decorate(arrayCommand);
  }

  @Override
  public String acceptVisitor(final Visitor visitor) {
    return visitor.visitArray(this);
  }

}
