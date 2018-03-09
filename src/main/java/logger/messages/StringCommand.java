package logger.messages;

import logger.Controller;
import logger.designer.Visitor;
import logger.messages.CommandUtils.CharStringUtils;

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
    sameCount = CharStringUtils.getSameCount(previousMessagee, controller, this);
    controller.setPreviousCommand(this);
  }

  @Override
  public String acceptVisitor(final Visitor visitor) {
    return visitor.visitString(this);
  }
}
