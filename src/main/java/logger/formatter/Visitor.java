package logger.formatter;

import logger.command.*;

/**
 * Интерфейс для выбора способа декорирования выводимого
 * сообщения, основанный на паттерне Посетитель
 */
public interface Visitor {
  String visitInt(IntCommand command);

  String visitString(StringCommand command);

  String visitBoolean(BooleanCommand command);

  String export(Command... args);

  String visitObject(ObjectCommand objectCommand);

  String visitChar(CharCommand charCommand);

  String visitByte(ByteCommand byteCommand);

  String visitArray(ArrayCommand arrayCommand);

  String visitMatrix(MatrixCommand matrixCommand);

}
