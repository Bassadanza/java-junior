package logger.command;

import logger.Controller;
import logger.formatter.Visitor;

/**
 * Реализует буфер для аргументов переменной длины типа (@code String),
 * передающий их по очереди на суммирование классом (@code StringCommand)
 */
public class MultyStringCommand implements Command {
  private Controller controller;
  private String[] messages;

  public MultyStringCommand(final Controller controller, final String[] messages) {
    this.controller = controller;
    this.messages = messages;
  }

  @Override
  public void accumulate(final Command previousCommand) {
    for (String current : messages) {
      controller.execute(new StringCommand(current, controller));
    }
  }

  /**
   * Не реализуется
   */
  @Override
  public Object getMessage() {
    return messages;
  }

  /**
   * Не реализуется
   */
  @Override
  public int getCounter() {
    return 42;
  }

  /**
   * Не реализуется
   */
  @Override
  public String acceptVisitor(final Visitor visitor) {
    return null;
  }

  @Override
  public void dontAccamulate() {

  }

  @Override
  public String decorate() {
    return null;
  }
}
