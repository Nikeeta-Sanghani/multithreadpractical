package multithreadpractically;

public class multithreadpractically {

    public static void main(String[] args) {
	    Data data = new Data();
	    Thread sender = new Thread(new Sender(data));
	    Thread receiver = new Thread(new Receiver(data));
	    
	    sender.start();
	    receiver.start();
	  //  System.out.println("Total number of Threads Running ->"+Thread.activeCount());
	    
	}
    
}
