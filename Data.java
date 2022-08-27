package multithreadpractically;

public class Data {
   
	    private String packet;
	    
	    
	    /* By Default always receiver should wait for sender to send
	     * Once sender has sent he should notify receiver hence it will start 
	     * Note wait and notify methods are called within synchronized class only otherwise it will throw error "ABC thread is not the owner of this XXXX thread"
	     * 
	     * */
	    private boolean transfer = true;
	    public synchronized void send(String packet) {
	        while (!transfer) {
	            try { 
	               System.out.println("Sender is waiting");
	        	wait();
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt(); 
	                System.out.println("Thread Interrupted");
	            }
	        }
	        transfer = false;
	        
	        this.packet = packet;
	        notifyAll();
	    }
	    
	    public synchronized String receive() {
	        while (transfer) {
	            try {
	        	System.out.println("Receiver is waiting");
	                wait();
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt(); 
	                System.out.println("Thread Interrupted");
	            }
	        }
	        transfer = true;
	        
	        String returnPacket = packet;
	        notifyAll();  // here since the class does not extend thread nor implement runnable we cannot use thread.notify method
	        return returnPacket;  // it returns the packet string to the data class instance
	    }
	 
	  
	}

