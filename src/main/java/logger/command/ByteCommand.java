package logger.command;

import logger.Controller;
import logger.command.CommandUtils.OverflowableDecimal;
import logger.formatter.Visitor;

public final class ByteCommand extends OverflowableDecimal implements Command {
  private Controller controller;
  private byte byteMessage;
  private byte byteSum = 0;

  public ByteCommand(final byte booleanMessage,
                     final Controller controller) {
    this.controller = controller;
    this.byteMessage = booleanMessage;
  }

  @Override
  protected int getMin() {
    return Byte.MIN_VALUE;
  }

  @Override
  protected int getMax() {
    return Byte.MAX_VALUE;
  }

  @Override
  public void accumulate(final Command previousCommand) {
    if(isOverflow(previousCommand,byteMessage)){
      controller.flush();
      dontAccamulate();
    }else{
      byteSum = (byte) (previousCommand.getCounter() + byteMessage);
    }
  }

  @Override
  public void dontAccamulate() {
    byteSum = byteMessage;
  }

  @Override
  public String decorate() {
    return String.valueOf(byteSum);
  }

  @Override
  public Object getMessage() {
    return byteMessage;
  }

  @Override
  public int getCounter() {
    return byteSum;
  }

  @Override
  public String acceptVisitor(final Visitor visitor) {
    return visitor.visitByte(this);
  }
}
