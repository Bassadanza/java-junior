package logger;

public class Main {
  public static void main(String[] args) {
    Logger.log('a');
    Logger.log(new Object());
    Logger.log(new Object());
    Logger.log(true);
    Logger.log(5);
    Logger.log(5);
    Logger.log(false);
    Logger.log(true);
    Logger.log(true);
    Logger.log(Integer.MAX_VALUE);
    Logger.log(300);
    //Logger.log(362, 10000000, 38495956);
    Logger.log("str1");
    Logger.log("str1");
    Logger.log("str3");
    Logger.log(new int[][]{{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
    Logger.log('a');
    Logger.log(Integer.MIN_VALUE);
    Logger.log(-500);
    Logger.log('a');
    Logger.log('b');
    Object a = new Object();
    Logger.log(a);
    Logger.log(a);
    Logger.log('a');
    Logger.log('a');
    Logger.log("str2");
    Logger.log(new int[][]{{-1, 0, 1}, {-999, 345, 8334}, {-3, -500, 1254}});
    Logger.log(5);
    Logger.log('a');
    Logger.log("str3");
    Logger.log("str3");
    Logger.log(5);
    Logger.log(false);
    Logger.log(new int[]{-1, 0, 1});
    //Logger.log(1, 10, 25, 40);
    Logger.flush();
  }
}
