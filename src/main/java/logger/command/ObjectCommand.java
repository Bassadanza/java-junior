package logger.command;

import logger.Controller;
import logger.formatter.Visitor;

public final class ObjectCommand implements Command {
  private int sameCounter;
  private Controller controller;
  private Object objectMessage;

  public ObjectCommand(final Object objectMessage,
                       final Controller controller) {
    this.controller = controller;
    this.objectMessage = objectMessage;
  }

  @Override
  public void accumulate(final Command previousCommand) {
    if(objectMessage.equals(previousCommand.getMessage())){
      sameCounter = previousCommand.getCounter() + 1;
    }else {
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
    return (String) objectMessage;
  }

  @Override
  public Object getMessage() {
    return objectMessage;
  }

  @Override
  public int getCounter() {
    return sameCounter;
  }

  @Override
  public String acceptVisitor(final Visitor visitor) {
    return visitor.visitObject(this);
  }
}
