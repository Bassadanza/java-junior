package logger.command;

import logger.formatter.Visitor;

public interface Command {
  /**
   * Аккумуляция входной команды
   *
   * @param command
   */
  boolean accumulate(final Command command);

  Object getMessage();

  int getCounter();

  String acceptVisitor(final Visitor visitor);

  void notAccumulated();

  String decorate();
}
