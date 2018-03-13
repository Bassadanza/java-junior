package logger.command;

import logger.Controller;
import logger.command.CommandUtils.ArrayFormatter;
import logger.formatter.Visitor;

public final class ArrayCommand extends ArrayFormatter implements Command {
  private int[] arrayCommand;
  private Controller controller;

  public ArrayCommand(final int[] arrayCommand,
                      final Controller controller) {
    this.arrayCommand = arrayCommand;
    this.controller = controller;
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
  public void accumulate(final Command previousCommand) {

  }

  @Override
  public void dontAccamulate() {
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
