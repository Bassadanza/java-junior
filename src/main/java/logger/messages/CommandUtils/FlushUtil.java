package logger.messages.CommandUtils;

import logger.Controller;
import logger.messages.Command;

public final class FlushUtil {
  private FlushUtil() {
  }

  /**
   * Обнуляет буфер
   * Используется для типов данных,
   * не требующих аккумуляции
   */
  public static void needToFlush(final Command previousCommand,
                                 final Controller controller) {
    if (previousCommand != null) {
      controller.flush();
    }
  }
}
