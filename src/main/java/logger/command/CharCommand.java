package logger.command;

import logger.command.CommandUtils.PrimitiveFormatterNAccumulate;
import logger.formatter.Visitor;

public final class CharCommand extends PrimitiveFormatterNAccumulate implements Command {

  private Character charMessage;
  private int sameCount = 0;

  public CharCommand(final char charMessage) {
    this.charMessage = charMessage;
  }

  @Override
  public Object getMessage() {
    return charMessage;
  }

  @Override
  public int getCounter() {
    return sameCount;
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
    sameCount = 1;
  }

  @Override
  protected void setSum(int counter) {
    this.sameCount = counter;
  }

  public String decorate() {
    return decorate(getMessage().toString(), getCounter());
  }

  @Override
  public String acceptVisitor(final Visitor visitor) {
    return visitor.visitChar(this);
  }
}
