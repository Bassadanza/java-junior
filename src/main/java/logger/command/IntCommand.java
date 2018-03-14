package logger.command;

import logger.command.CommandUtils.DecimalOverflowNAccumulator;
import logger.formatter.Visitor;

public final class IntCommand extends DecimalOverflowNAccumulator implements Command {
  private final int intMessage;
  private int intSum = 0;

  public IntCommand(final int intMessage) {
    this.intMessage = intMessage;
  }

  @Override
  protected int getMin() {
    return Integer.MIN_VALUE;
  }

  @Override
  protected int getMax() {
    return Integer.MAX_VALUE;
  }

  public Object getMessage() {
    return intMessage;
  }

  @Override
  public int getCounter() {
    return intSum;
  }

  @Override
  public boolean accumulate(final Command previousCommand) {
    return accumulate(
        intMessage,
        previousCommand.getCounter());
  }

  @Override
  public void notAccumulated() {
    intSum = intMessage;
  }

  @Override
  protected void setCounter(int sum) {
    this.intSum = sum;
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
