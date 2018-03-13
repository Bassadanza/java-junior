package logger.command;

import logger.Controller;
import logger.formatter.Visitor;

/**
 * Аккумулирование входных команд типа (@Link String)
 */
public final class StringCommand implements Command {
  ;
  /* Текущее сообщение */
  private String stringMessage;
  /* Счётчик схожих сообщений, по умолчанию 0 */
  private int sameCount = 0;
  private Controller controller;


  public int getCounter() {
    return sameCount;
  }

  public StringCommand(final String command,
                       final Controller controllerr) {
    this.stringMessage = command;
    this.controller = controllerr;
  }

  @Override
  public Object getMessage() {
    return stringMessage;
  }

  @Override
  public void accumulate(final Command previousMessagee) {
    sameCount = previousMessagee.getCounter() + 1;
  }

  @Override
  public void dontAccamulate() {
    sameCount = 1;
  }

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
    return visitor.visitString(this);
  }
}
