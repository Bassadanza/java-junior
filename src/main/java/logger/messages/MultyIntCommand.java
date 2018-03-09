package logger.messages;

import logger.Controller;
import logger.designer.Visitor;

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

  /**
   * Не реализуется
   */
  @Override
  public String acceptVisitor(final Visitor visitor) {
    return null;
  }
}
