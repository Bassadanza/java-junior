package logger.command.CommandUtils;

public abstract class DecimalOverflowNAccumulator {

  protected abstract int getMin();

  protected abstract int getMax();

  private boolean isOverflow(final int previousCounter,
                               final int message) {
    return (long) message
        + previousCounter <= getMax()
        && (long) message
        + previousCounter >= getMin();
  }

  protected boolean accumulate(int message, int previousCounter){
    if (isOverflow(previousCounter, message)) {
      setCounter((previousCounter + message));
      return true;
    } else {
      notAccumulated();
      return false;
    }
  }

  protected abstract void notAccumulated();

  protected abstract void setCounter(int sum);
}
