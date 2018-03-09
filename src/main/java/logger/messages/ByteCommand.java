package logger.messages;

import logger.Controller;
import logger.designer.Visitor;

public final class ByteCommand implements Command {
  private Controller controller;
  private byte byteMessage;
  private byte byteSum = 0;

  public ByteCommand(final byte booleanMessage,
                     final Controller controller) {
    this.controller = controller;
    this.byteMessage = booleanMessage;
  }

  @Override
  public void accumulate(final Command previousCommand) {
    havePreviousCommand(previousCommand);
    controller.setPreviousCommand(this);
  }

  private void havePreviousCommand(final Command previousCommand) {
    if (previousCommand != null) {
      if (controller.isTheSameType(this)) {
        isOverflow(previousCommand);
      } else {
        controller.flush();
        byteSum = byteMessage;
      }
    } else {
      byteSum = byteMessage;
    }
  }

  private void isOverflow(final Command previousMessagge) {
    if (byteMessage
        + previousMessagge.getCounter() > Byte.MAX_VALUE || byteMessage
        + previousMessagge.getCounter() < Byte.MIN_VALUE) {
      controller.flush();
      byteSum = byteMessage;
    } else {
      byteSum = (byte) (previousMessagge.getCounter() + byteMessage);
    }
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
