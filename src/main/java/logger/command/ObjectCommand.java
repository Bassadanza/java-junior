package logger.command;

import logger.command.CommandUtils.PrimitiveFormatterNAccumulate;
import logger.formatter.Visitor;

public final class ObjectCommand extends PrimitiveFormatterNAccumulate implements Command {
  private int sameCounter;
  private Object objectMessage;

  public ObjectCommand(final Object objectMessage) {
    this.objectMessage = objectMessage;
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
  protected void setSum(int counter) {
    this.sameCounter = counter;
  }

  @Override
  public boolean accumulate(final Command previousCommand) {
    return accumulate(
        previousCommand.getMessage().toString(),
        getMessage().toString(),
        previousCommand.getCounter());
  }

  @Override
  public void dontAccumulate() {
    sameCounter = 1;
  }

  @Override
  public String decorate() {
    return decorate(getMessage().toString(), getCounter());
  }

  @Override
  public String acceptVisitor(final Visitor visitor) {
    return visitor.visitObject(this);
  }
}
