package logger.command;

import logger.Controller;
import logger.command.CommandUtils.OverflowableDecimal;
import logger.formatter.Visitor;

public final class IntCommand extends OverflowableDecimal implements Command {
  private int intMessage;
  private Controller controller;
  private int intSum = 0;

  public IntCommand(final int intMessage,
                    final Controller controllerr) {
    this.intMessage = intMessage;
    this.controller = controllerr;
  }

  @Override
  protected int getMin() {
    return Integer.MIN_VALUE;
  }

  @Override
  protected int getMax() {
    return Integer.MIN_VALUE;
  }

  public Object getMessage() {
    return intMessage;
  }

  @Override
  public int getCounter() {
    return intSum;
  }

  @Override
  public void accumulate(final Command previousCommand) {
    if(isOverflow(previousCommand, intMessage)){
      controller.flush();
      intSum = intMessage;
    }else{
        intSum = previousCommand.getCounter() + intMessage;
    }
  }

  @Override
  public void dontAccamulate() {
    intSum = intMessage;
  }

  @Override
  public String decorate() {
    return String.valueOf(intSum);
  }

  @Override
  public String acceptVisitor(final Visitor visitor) {
    return visitor.visitInt(this);
  }
}
