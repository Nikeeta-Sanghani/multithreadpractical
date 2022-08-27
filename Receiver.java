package multithreadpractically;

import java.lang.System.Logger;
import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable {
    private Data load;
 
    // standard constructors
 
    public Receiver(Data data) {
	load=data;
	// TODO Auto-generated constructor stub
    }

    public void run() {
        for(String receivedMessage = load.receive();
          !"End".equals(receivedMessage); // means when "End" is sent by Sender
          receivedMessage = load.receive()) {
            
            System.out.println("Received data ->"+receivedMessage);
           
            // ...
            try {
        	System.out.println("Again Receiver is waiting");
        	 
        	
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                 
            }
        }
        System.out.println("Received \"End\" Exiting the thread");
    }
}