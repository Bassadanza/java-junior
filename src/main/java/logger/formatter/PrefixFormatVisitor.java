package logger.formatter;

import logger.command.*;

/**
 * Конкретная реализация декорирования выводимого сообщения
 * с префиксом
 */
public final class PrefixFormatVisitor implements Visitor {
  private static final String CHAR_PREFIX = "char: ";
  private static final String REFERENCE_PREFIX = "reference: ";
  private static final String PRIMITIVE_PREFIX = "primitive: ";
  private static final String PRIMITIVE_ARRAY_PREFIX = "primitives array: ";
  private static final String PRIMITIVE_ARRAY_MATRIX = "primitives matrix: ";

  public String export(final Command... args) {
    String message = "";
    for (Command command : args) {
      message = command.acceptVisitor(this);
    }
    return message;
  }

  @Override
  public String visitInt(final IntCommand intCommand) {
    return PRIMITIVE_PREFIX
        + intCommand.decorate();
  }

  @Override
  public String visitString(final StringCommand stringCommand) {
    return PRIMITIVE_PREFIX
        + stringCommand.decorate();
  }

  @Override
  public String visitBoolean(final BooleanCommand booleanCommand) {
    return PRIMITIVE_PREFIX
        + booleanCommand.decorate();
  }

  @Override
  public String visitObject(final ObjectCommand objectCommand) {
    return REFERENCE_PREFIX
        + objectCommand.decorate();
  }

  @Override
  public String visitChar(final CharCommand charCommand) {
    return CHAR_PREFIX
        + charCommand.decorate();
  }

  @Override
  public String visitByte(final ByteCommand byteCommand) {
    return PRIMITIVE_PREFIX
        + byteCommand.decorate();
  }

  @Override
  public String visitArray(final ArrayCommand arrayCommand) {
    return PRIMITIVE_ARRAY_PREFIX
        + arrayCommand.decorate();
  }

  @Override
  public String visitMatrix(final MatrixCommand matrixCommand) {
    return PRIMITIVE_ARRAY_MATRIX
        + matrixCommand.decorate();
  }
}
