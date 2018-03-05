package demo;

import demo.messages.IntMessagee;

public class Main{

   private static Controllerr controller = new Controllerr();

   public static void log(Integer message){
       controller.execute(new IntMessagee(message, controller));
   }

}
