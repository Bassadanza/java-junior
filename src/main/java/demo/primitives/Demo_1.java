package demo.primitives;

import static java.lang.Math.sin;

public class Demo_1 {
    //region state
    public static String state = null; //Global state
    public static final String MY_CONST = "";
    //endregion

    static {
        System.out.println(Demo_1.state);
        log(1, 2);
    }

    public static int log(int i1, int i2) {
        int localIntVar = 0; //local, auto, temp, stack
        //region output
        System.out.println("primitive: " + localIntVar);
        return 0;
        //endregion
    }

    public static void log(byte message) {
        int localIntVar = 0;
        System.out.println("primitive: " + message);
        log(0);
    }

    public static void log(int message) {
        sin(0);
    }


static class Demo {
    public static void main(String[] args) {
        log(1, 1);
        log(0);
        System.out.println(MY_CONST);
    }
}
}