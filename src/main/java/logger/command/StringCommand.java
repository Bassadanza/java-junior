package logger.command;

import logger.command.CommandUtils.PrimitiveFormatterNAccumulator;
import logger.formatter.Visitor;

/**
 * Аккумулирование входных команд типа (@Link String)
 */
public final class StringCommand extends PrimitiveFormatterNAccumulator implements Command {
  ;
  /* Текущее сообщение */
  private final String stringMessage;
  /* Счётчик схожих сообщений, по умолчанию 0 */
  private int sameCount = 0;


  public StringCommand(final String message) {
    this.stringMessage = message;
  }

  @Override
  public String getMessage() {
    return stringMessage;
  }

  public int getCounter() {
    return sameCount;
  }

  @Override
  protected void setSum(int counter) {
    this.sameCount = counter;
  }

  @Override
  public boolean accumulate(final Command previousCommand) {
    return accumulate(
        previousCommand.getMessage().toString(),
        getMessage(),
        previousCommand.getCounter());
  }

  @Override
  public void notAccumulated() {
    sameCount = 1;
  }

  public String decorate() {
    return decorate(getMessage(), getCounter());
  }

  @Override
  public String acceptVisitor(final Visitor visitor) {
    return visitor.visitString(this);
  }
}
