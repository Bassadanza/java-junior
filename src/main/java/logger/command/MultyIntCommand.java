package logger.command;

import logger.Controller;
import logger.formatter.Visitor;

import java.util.Arrays;

/**
 * Реализует буфер для аргументов переменной длины типа (@code int),
 * передающий их по очереди на суммирование классом (@code IntCommand)
 */
public class MultyIntCommand implements Command {
  private Controller controller;
  private Integer[] messages;

  public MultyIntCommand(final Controller controller, final Integer[] messages) {
    this.controller = controller;
    this.messages = messages;
  }

  @Override
  public void accumulate(final Command previousCommand) {

  }

  @Override
  public void dontAccamulate() {
    for (int current : messages) {
      controller.execute(new IntCommand(current, controller));
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
