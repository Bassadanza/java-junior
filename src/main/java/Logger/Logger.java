package Logger;

import Logger.Designer.DesignVisitor;
import Logger.messages.*;

/**
 * Логгирование сообщений разного типа
 * @author Дмитрий Торопин
 */
public class Logger {
    private static Controller controller = new Controller(
            System.out::println,
            new DesignVisitor());

    /**
     * Логирование сообщения {@code message} типа {@code int}
     * @param message объект типа {@code int} для логирования
     */
    public static void log(final int message) {
        controller.execute(new IntCommand(message, controller));
    }

    /**
     * Логирование сообщения {@code message} типа {@code int}
     * @param messages объект типа {@code Integer[]} для логирования
     */
    public static void log(final Integer... messages) {
        controller.execute(new MultyIntCommand(controller, messages));
    }

    /**
     * Логирование сообщения {@code message} типа {@link String}
     * @param message объект типа {@code String} для логирования
     */
    public static void log(final String message) {
        controller.execute(new StringCommand(message, controller));
    }

    /**
     * Логирование сообщения {@code message} типа {@link String}
     * @param messages объект типа {@link String...} для логирования
     */
    public static void log(final String... messages) {
        controller.execute(new MultyStringCommand(controller, messages));
    }

    /**
     * Логирование сообщения {@code message} типа {@code boolean}
     * @param message объект типа {@code boolean} для логирования
     */
    public static void log(final boolean message) {
        controller.execute(new BooleanCommand(message, controller));
    }

    /**
     * Логирование сообщения {@code message} типа {@code byte}
     * @param message объект типа {@code byte} для логирования
     */
    public static void log(final byte message) {
        controller.execute(new ByteCommand(message, controller));
    }

    /**
     * Логирование сообщения {@code message} типа {@code char}
     * @param message объект типа {@code char} для логирования
     */
    public static void log(final char message) {
        controller.execute(new CharCommand(message, controller));
    }

    /**
     * Логирование сообщения {@code message} типа {@code int[]}
     * @param message объект типа {@code int[]} для логирования
     */
    public static void log(final int[] message) {
        controller.execute(new ArrayCommand(message, controller));
    }

    /**
     * Логирование сообщения {@code message} типа {@code int[][]}
     * @param message объект типа {@code int[][]} для логирования
     */
    public static void log(final int[][] message) {
        controller.execute(new MatrixCommand(message, controller));
    }

    /**
     * Логирование сообщения {@code message} типа {@link Object}
     * @param message объект типа {@link Object} для логирования
     */
    public static void log(final Object message) {
        controller.execute(new ObjectCommand(message, controller));
    }

    /**
     * Вывод накопленных сообщений из буфера
     */
    public static void flush() {
        controller.flush();
    }
}
