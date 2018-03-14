package logger.printer;

/**
 * Интерфейс вывода сообщений
 */
@FunctionalInterface
public interface Printer {
    void print(final Object decorate);
}
