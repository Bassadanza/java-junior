package logger.command.CommandUtils;

public abstract class PrimitiveFormatterNAccumulator {
  public String decorate(String message, int counter) {
    if (counter > 1) {
      return message
          + " (x"
          + counter
          + ")";
    } else {
      return String.valueOf(message);
    }
  }

  protected boolean accumulate(String previousMessage, String message, int previousCounter) {
    if(previousMessage.equals(message)) {
      setSum(previousCounter + 1);
      return true;
    } else {
      notAccumulated();
      return false;
    }
  }

  protected abstract void notAccumulated();

  protected abstract void setSum(int counter);
}
