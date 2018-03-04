package com.acme.Logger;


import com.acme.Logger.messages.*;
import com.acme.Logger.printer.ConsolePrinter;

public class Logger {
    private static Controller controller = new Controller(new ConsolePrinter());

    //region Test 1, 2
    public static void log(final Integer intMessage) {
        controller.print(new IntMessage(intMessage, controller));
    }

    public static void log(final Byte byteMessage) {
        controller.print(new ByteMessage(byteMessage, controller));
    }

    public static void log(final Character charMessage) {
        controller.print(new CharMessage(charMessage));
    }

    public static void log(final String stringMessage) {
        controller.print(new StringMessage(stringMessage, controller));
    }

    public static void log(final Boolean booleanMessage) {
        controller.print(new BooleanMessage(booleanMessage));
    }

    public static void log(final Object objectMessage) {
        controller.print(new ObjectMessage(objectMessage));
    }
    //endregion

    public static void log(final int[] message) {

        System.out.println("primitives array: " + arrOut(message).toString());
    }

    public static void log(final int[][] message) {
        String test = matrixOut(message);
        System.out.println("primitives matrix: " + test);
    }

    public static void flush() {
        //System.out.println(controller.getIntSum());
        //controller.setIntSum(-controller.getIntSum());
        controller.flush();
    }

    private static StringBuffer arrOut(final int[] message) {
        StringBuffer strBuff = new StringBuffer();
        strBuff.append("{");
        for (int i = 0; i < message.length; i++) {
            strBuff.append(message[i]);
            if (i != message.length - 1) {
                strBuff.append(", ");
            }
        }
        strBuff.append("}");
        return strBuff;
    }

    private static String matrixOut(final int[][] message) {
        StringBuilder strBuff = new StringBuilder();
        strBuff.append("{").append(System.getProperty("line.separator"));
        for (int[] aMessage : message) {
            strBuff.append(arrOut(aMessage)).append(System.getProperty("line.separator"));
        }
        strBuff.append("}");
        return strBuff.toString();
    }
}