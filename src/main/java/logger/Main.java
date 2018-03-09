package Logger;

public class Main {
    public static void main(String[] args) {
        Logger.log('a');
        Logger.log(true);
        Logger.log(5);
        Logger.log(5);
        Logger.log(false);
        Logger.log(true);
        Logger.log(true);
        Logger.log(5);
        Logger.log("str1");
        Logger.log("str1");
        Logger.log('a');
        Logger.log('a');
        Logger.log('a');
        Logger.log("str2");
        Logger.log(5);
        Logger.log('a');
        Logger.log("str3");
        Logger.log("str3");
        Logger.log(5);
        Logger.log(false);
        Logger.log(new int[] {-1, 0, 1});
        Logger.flush();
    }
}
