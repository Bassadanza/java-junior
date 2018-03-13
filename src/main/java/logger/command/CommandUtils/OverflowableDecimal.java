package logger.command.CommandUtils;

import logger.command.Command;

public abstract class OverflowableDecimal {

  protected abstract int getMin();
  protected abstract int getMax();

  protected boolean isOverflow(Command previousCommand,
                           int message) {
    return (long) message
        + previousCommand.getCounter() <= getMax()
        && (long) message
        + previousCommand.getCounter() >= getMin();
  }
}
