package logger.messages;

import logger.Controller;
import logger.designer.Visitor;
import logger.messages.CommandUtils.FlushUtil;

public final class ArrayCommand implements Command {
  private int[] arrayCommand;
  private Controller controller;

  public ArrayCommand(final int[] arrayCommand,
                      final Controller controller) {
    this.arrayCommand = arrayCommand;
    this.controller = controller;
  }

  @Override
  public void accumulate(final Command previousCommand) {
    FlushUtil.needToFlush(previousCommand, controller);
    controller.setPreviousCommand(this);
  }

  @Override
  public Object getMessage() {
    return arrayCommand;
  }

  /**
   * Суммирование сообщений типа (@code int[]) не предусмотрено.
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
