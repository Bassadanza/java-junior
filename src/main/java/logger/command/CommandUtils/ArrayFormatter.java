package logger.command.CommandUtils;

public class ArrayFormatter {
  public String decorate(int[] arrayMessage) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("{");
    for (int i = 0; i < arrayMessage.length; i++) {
      stringBuilder.append(arrayMessage[i]);
      if (i != arrayMessage.length - 1) {
        stringBuilder.append(", ");
      }
    }
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}

