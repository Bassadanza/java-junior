package com.acme.edu;


import java.util.Scanner;

import static com.acme.edu.Logger.*;
import static java.lang.Math.sin;


public class Logger {
    static int count = 0;

    public static void log(byte message) {
        System.out.println("primitive: " + message);
    }

    public static void log(int message) {
        count += message;
    }

    public static void log(char message) {
        System.out.println("char: " + message);
    }

    public static void log(String message) {
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
}

