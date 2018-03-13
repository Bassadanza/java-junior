package logger.command;

import logger.command.CommandUtils.PrimitiveFormatterNAccumulate;
import logger.formatter.Visitor;

/**
 * Аккумулирование входных команд типа (@Link String)
 */
public final class StringCommand extends PrimitiveFormatterNAccumulate implements Command {
  ;
  /* Текущее сообщение */
  private String stringMessage;
  /* Счётчик схожих сообщений, по умолчанию 0 */
  private int sameCount = 0;


  public StringCommand(final String command) {
    this.stringMessage = command;
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
        getMessage().toString(),
        previousCommand.getCounter());
  }

  @Override
  public void dontAccumulate() {
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
