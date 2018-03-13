package logger.command.CommandUtils;

public abstract class DecimalOverflowNAccumulate {

  protected abstract int getMin();

  protected abstract int getMax();

  protected boolean isOverflow(final int previousCounter,
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
      dontAccumulate();
      return false;
    }
  }

  protected abstract void dontAccumulate();

  protected abstract void setCounter(int sum);
}
