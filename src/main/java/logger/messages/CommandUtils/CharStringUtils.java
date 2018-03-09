package logger.messages.CommandUtils;

import logger.Controller;
import logger.messages.Command;

/**
 * Логика аккумулирования строковых
 * и символьных типов данных
 */
public final class CharStringUtils {
  private CharStringUtils() {
  }

  private static Command utilPreviousCommand;
  private static Controller utilController;
  private static Command utilConcreteCommand;

  public static int getSameCount(final Command previousCommand,
                                 final Controller controller,
                                 final Command concreteCommand) {
    utilPreviousCommand = previousCommand;
    utilController = controller;
    utilConcreteCommand = concreteCommand;
    return havePreviousCommand();
  }

  private static int havePreviousCommand() {
    if (utilPreviousCommand != null) {
      if (utilController
          .isTheSameType(utilConcreteCommand)) {
        return areEquals();
      } else {
        utilController.flush();
        return 1;
      }
    } else {
      return 1;
    }
  }

  private static int areEquals() {
    if (utilConcreteCommand.getMessage()
        .equals(utilPreviousCommand.getMessage())) {
      return utilPreviousCommand.getCounter() + 1;
    } else {
      utilController.flush();
      return 1;
    }
  }
}
