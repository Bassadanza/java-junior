package com.acme.edu;

public class Logger {
    static int count = 0;

    public static void log(byte message) {
        /*if (message == Byte.MAX_VALUE) {
            flush();
        } else {*/
        System.out.println("primitive: " + message);
        //}
    }

    public static void log(int message) {
        if (count + (long) message > Integer.MAX_VALUE || count + (long)message > Integer.MIN_VALUE) {
            flush();
        }
        count += message;
    }

    public static void log(int[] message) {
        System.out.println("primitives array: " + arrOut(message).toString());
    }

    public static void log(int[][] message) {
        String test = matrixOut(message);
        System.out.println("primitives matrix: " + test);
    }

    public static void log(char message) {
        System.out.println("char: " + message);
    }

    public static void log(String message) {
        if (count != 0) {
            flush();
        }
        System.out.println("string: " + message);
    }

    public static void log(boolean message) {
        System.out.println("primitive: " + message);
    }

    public static void log(Object message) {
        System.out.println("reference: " + message);
    }

    public static void flush() {
        System.out.println(count);
        count = 0;
    }

    public static StringBuffer arrOut(int[] message) {
        StringBuffer strBuff = new StringBuffer();
        strBuff.append("{");
        for (int i = 0; i < message.length; i++) {
            strBuff.append(message[i]);
            if (i != message.length - 1) strBuff.append(", ");
        }
        strBuff.append("}");
        return strBuff;
    }

    public static String matrixOut(int[][] message) {
        StringBuffer strBuff = new StringBuffer();
        strBuff.append("{" + System.getProperty("line.separator"));
        for (int i = 0; i < message.length; i++) {
            strBuff.append(
                    arrOut(message[i]) + System.getProperty("line.separator"));
        }
        strBuff.append("}");
        return strBuff.toString();
    }
}

