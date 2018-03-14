package logger.printer;

public class ConsolePrinter implements Printer {
    @Override
    public void print(Object decorate) {
        System.out.println(decorate.toString());
    }
}
