package logger.command;

import logger.command.CommandUtils.DecimalOverflowNAccumulate;
import logger.formatter.Visitor;

public final class ByteCommand extends DecimalOverflowNAccumulate implements Command {
  private byte byteMessage;
  private byte byteSum = 0;

  public ByteCommand(final byte booleanMessage) {
    this.byteMessage = booleanMessage;
  }

  @Override
  public Byte getMessage() {
    return byteMessage;
  }

  @Override
  public int getCounter() {
    return byteSum;
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
  public boolean accumulate(final Command previousCommand) {
    return accumulate(byteMessage, previousCommand.getCounter());
  }

  @Override
  public void dontAccumulate() {
    byteSum = byteMessage;
  }

  @Override
  protected void setCounter(int sum) {
    this.byteSum = (byte) sum;
  }

  @Override
  public String decorate() {
    return String.valueOf(byteSum);
  }

  @Override
  public String acceptVisitor(final Visitor visitor) {
    return visitor.visitByte(this);
  }
}
