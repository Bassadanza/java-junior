package logger.messages;

import logger.Controller;
import logger.designer.Visitor;
import logger.messages.CommandUtils.FlushUtil;

public final class ObjectCommand implements Command {
  private Controller controller;
  private Object objectMessage;

  public ObjectCommand(final Object objectMessage,
                       final Controller controller) {
    this.controller = controller;
    this.objectMessage = objectMessage;
  }

  @Override
  public void accumulate(final Command previousCommand) {
    FlushUtil.needToFlush(previousCommand, controller);
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
