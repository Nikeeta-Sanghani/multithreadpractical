package multithreadpractically;

import java.util.concurrent.ThreadLocalRandom;

public class Sender implements Runnable {
    private Data data;
 
    // standard constructors
 
    public Sender(Data data2) {
	data=data2;// TODO Auto-generated constructor stub
    }

    public void run() {
        String packets[] = {
          "First Packet",
          "Second Packet",
          "Third Packet",
          "Fourth Packet",
          "End"
        };
 
        for (String packet : packets) {
            {
        	  System.out.println("\nSending data ->"+packet);
        	data.send(packet);
        	
            }

            // Thread.sleep() to mimic heavy server-side processing
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                
            }
        }
    }
}