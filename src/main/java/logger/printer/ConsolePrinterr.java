package logger.printer;

public class ConsolePrinterr implements Printerr {
    @Override
    public void print(Object decorate) {
        System.out.println(decorate.toString());
    }
}
