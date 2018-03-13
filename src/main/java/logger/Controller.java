package logger;

import logger.formatter.Visitor;
import logger.command.Command;
import logger.printer.Printerr;


/**
 * Управление процессом логирования
 * и хранение предыдущей команды.
 * (@code previousCommand) типа (@code Command)
 */
public final class Controller {
  private Printerr printer;
  private Command previousCommand = null;
  private Visitor concreteVisitor;

  public Controller(final Printerr printer,
                    final Visitor visitor) {
    this.concreteVisitor = visitor;
    this.printer = printer;
  }

  public void setPreviousCommand(final Command previousCommand) {
    this.previousCommand = previousCommand;
  }

  /**
   * Обработка команды {@code command} на основе
   * предыдущей забуферизованной команды (@previousCommand).
   *
   * @param command сообщение для логирования
   */
  public void execute(final Command command) {
    if (previousCommand != null) {
      if (isTheSameType(command)) {
        command.accumulate(previousCommand);
      } else {
        flush();
        command.dontAccamulate();
      }
    }else{
      command.dontAccamulate();
    }
    setPreviousCommand(command);
  }

  /**
   * Сравнение типов текущей и забуферизованной команды.
   *
   * @param command текущая команда
   * @return true, если типы совпадают
   * false, если типы разные
   */
  public boolean isTheSameType(final Command command) {
    return previousCommand.getMessage().getClass()
        .equals(command.getMessage().getClass());
  }

  /**
   * Вывод аккумулированного сообщения из буфера.
   */
  public void flush() {
    printer.print(concreteVisitor.export(previousCommand));
  }
}
