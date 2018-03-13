package logger.command;

import logger.formatter.Visitor;

public interface Command {
  /**
   * Аккумуляция входной команды
   *
   * @param command
   */
  void accumulate(final Command command);

  Object getMessage();

  int getCounter();

  String acceptVisitor(final Visitor visitor);

  void dontAccamulate();

  String decorate();
}
