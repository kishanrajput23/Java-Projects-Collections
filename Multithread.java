class MultithreadExm implements Runnable {  
    public void run()  
    {  
        try {  
            // It shows that thread is running  
            System.out.println(  
                "The thread " + Thread.currentThread().getId()  
                + " is currently running");  
        }  
        catch (Exception e) {  
            System.out.println("Catching exception");  
        }  
    }  
}  
class multithrdexp {  
 public static void main(String[] args)  
 {  
     int n = 5; // Number of threads  
     for (int i = 0; i < n; i++) {  
         Thread object  
             = new Thread(new MultithreadExm());  
         object.start();  
     }  
 }  
}  
