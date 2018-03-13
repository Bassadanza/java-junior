package logger.command;

import logger.Controller;
import logger.formatter.Visitor;

public final class BooleanCommand implements Command {
  private int sameCounter;
  private Controller controller;
  private boolean booleanMessage;

  public BooleanCommand(final boolean booleanMessage,
                        final Controller controller) {
    this.controller = controller;
    this.booleanMessage = booleanMessage;
  }

  /**
   * Предусмотрена возможность реализации суммирования
   * сообщений типа Boolean
   */
  @Override
  public int getCounter() {
    return sameCounter;
  }

  @Override
  public Object getMessage() {
    return booleanMessage;
  }

  @Override
  public void accumulate(final Command previousCommand) {
    if(getMessage() == previousCommand.getMessage()){
      sameCounter = previousCommand.getCounter() + 1;
    }else{
      controller.flush();
      dontAccamulate();
    }
  }

  @Override
  public void dontAccamulate() {
    sameCounter = 1;
  }

  @Override
  public String decorate() {
    if (getCounter() > 1) {
      return getMessage()
          + " (x"
          + getCounter()
          + ")";
    } else {
      return String.valueOf(getMessage());
    }
  }

  @Override
  public String acceptVisitor(final Visitor visitor) {
    return visitor.visitBoolean(this);
  }
}
