package logger;

import logger.formatter.Visitor;
import logger.command.Command;
import logger.printer.Printer;


/**
 * Управление процессом логирования
 * и хранение предыдущей команды.
 * (@code previousCommand) типа (@code Command)
 */
public final class Controller {
  private final Printer printer;
  private Command previousCommand = null;
  private final Visitor concreteVisitor;

  public Controller(final Printer printer,
                    final Visitor visitor) {
    this.concreteVisitor = visitor;
    this.printer = printer;
  }

  private void setPreviousCommand(final Command previousCommand) {
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
        if (!command.accumulate(previousCommand)) {
          flush();
        }
      } else {
        flush();
        command.notAccumulated();
      }
    } else {
      command.notAccumulated();
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
  private boolean isTheSameType(final Command command) {
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
