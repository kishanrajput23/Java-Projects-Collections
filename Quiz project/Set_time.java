 class Set_time extends Thread {

   static protected int t;

   static void set(int time) {
      System.out.println("Participants have to answer each question in " + time + " seconds");

      t = time;

   }

}
