package logger.command;

import logger.Controller;
import logger.formatter.Visitor;

public final class CharCommand implements Command {

  private Controller controller;
  private Character charMessage;
  private int sameCount = 0;

  public CharCommand(final char charMessage, final Controller controller) {
    this.controller = controller;
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
    return visitor.visitChar(this);
  }
}
