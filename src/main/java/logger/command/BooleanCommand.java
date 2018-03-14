package logger.command;

import logger.command.CommandUtils.PrimitiveFormatterNAccumulator;
import logger.formatter.Visitor;

public final class BooleanCommand extends PrimitiveFormatterNAccumulator implements Command {
  private int sameCounter;
  private final boolean booleanMessage;

  public BooleanCommand(final boolean booleanMessage) {
    this.booleanMessage = booleanMessage;
  }

  @Override
  public Object getMessage() {
    return booleanMessage;
  }

  /**
   * Предусмотрена возможность реализации суммирования
   * сообщений типа Boolean
   */
  @Override
  public int getCounter() {
    return sameCounter;
  }

  public void setSum(int counter) {
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
  public void notAccumulated() {
    sameCounter = 1;
  }

  @Override
  public String decorate() {
    return decorate(getMessage().toString(), getCounter());
  }

  @Override
  public String acceptVisitor(final Visitor visitor) {
    return visitor.visitBoolean(this);
  }
}
