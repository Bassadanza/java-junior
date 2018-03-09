package logger.messages;

import logger.Controller;
import logger.designer.Visitor;
import logger.messages.CommandUtils.CharStringUtils;

public final class CharCommand implements Command {

  private Controller controller;
  private Character charMessage;
  private int sameCount;

  public CharCommand(final char charMessage, final Controller controller) {
    this.controller = controller;
    this.charMessage = charMessage;
  }

  @Override
  public void accumulate(final Command previousMessagee) {
    sameCount = CharStringUtils.getSameCount(previousMessagee, controller, this);
    controller.setPreviousCommand(this);
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
  public String acceptVisitor(final Visitor visitor) {
    return visitor.visitChar(this);
  }
}
