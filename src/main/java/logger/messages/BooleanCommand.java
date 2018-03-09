package logger.messages;

import logger.Controller;
import logger.designer.Visitor;
import logger.messages.CommandUtils.FlushUtil;

public final class BooleanCommand implements Command {

  private Controller controller;
  private boolean booleanMessage;

  public BooleanCommand(final boolean booleanMessage,
                        final Controller controller) {
    this.controller = controller;
    this.booleanMessage = booleanMessage;
  }

  @Override
  public void accumulate(final Command previousCommand) {
    FlushUtil.needToFlush(previousCommand, controller);
    controller.setPreviousCommand(this);
  }

  @Override
  public Object getMessage() {
    return booleanMessage;
  }

  /**
   * Предусмотрена возможность реализации суммирования
   * сообщений типа Boolean
   *
   * @return
   */
  @Override
  public int getCounter() {
    return 42;
  }

  @Override
  public String acceptVisitor(final Visitor visitor) {
    return visitor.visitBoolean(this);
  }
}
