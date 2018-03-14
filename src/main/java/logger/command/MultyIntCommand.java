package logger.command;

import logger.Controller;
import logger.formatter.Visitor;

/**
 * Реализует буфер для аргументов переменной длины типа (@code int),
 * передающий их по очереди на суммирование классом (@code IntCommand)
 */
public class MultyIntCommand implements Command {
  private final  Controller controller;
  private final Integer[] messages;

  public MultyIntCommand(final Controller controller, final Integer[] messages) {
    this.controller = controller;
    this.messages = messages;
  }

  @Override
  public boolean accumulate(final Command previousCommand) {

    return true;
  }

  @Override
  public void notAccumulated() {
    for (int current : messages) {
      controller.execute(new IntCommand(current));
    }
  }

  /**
   * Не реализуется
   */
  @Override
  public Object getMessage() {
    return null;
  }

  /**
   * Не реализуется
   */
  @Override
  public int getCounter() {
    return 0;
  }

  @Override
  public String decorate() {
    return null;
  }

  @Override
  public String acceptVisitor(final Visitor visitor) {
    return null;
  }
}
