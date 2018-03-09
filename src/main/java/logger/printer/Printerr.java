package logger.printer;

/**
 * Интерфейс вывода сообщений
 */
@FunctionalInterface
public interface Printerr {
    void print(final Object decorate);
}
