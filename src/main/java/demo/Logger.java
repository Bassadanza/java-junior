package demo;

import demo.messages.IntMessagee;
import demo.messages.StrMessagee;

public class Logger{

   private static Controllerr controller = new Controllerr();

   public static void log(Integer message){
       controller.execute(new IntMessagee(message, controller));
   }

    public static void log(String message){
        controller.execute(new StrMessagee(message, controller));
    }

   public static void flush(){
       controller.flush();
   }
}
