package notifications;

import java.util.Scanner;

public class TestNotificationExample {
	
	private	static volatile boolean stopMe = false;	
	
	public static void	stopMe() {	
		stopMe = true;	
	}

	public static void main(String[] args) {
		
		//create a Scanner to get user input in main thread
		Scanner userInput = new Scanner(System.in);
		
		//create an Updatable instance
		MarketNews aObject = new MarketNews();
		
		//create and start two threads that update the MarketNews object
		ClassB myB1 = new ClassB(aObject, "ORCL");
		myB1.start();
		ClassB myB2 = new ClassB(aObject, "AMZN");
		myB2.start();
		
		//start the Updatable MarketNews instance
		aObject.start();
		
		//when the user hits s + Enter, interrupt MarketNews and terminate main
		do {
			if (userInput.hasNext()){
				switch (userInput.next()) {
				case "s": 
					//interrupt MarketNews instance
					//aObject.interrupt();
					//stop all running threads
					aObject.stopMe();
					myB1.stopMe();
					myB2.stopMe();
					stopMe();
					break;
				}
			}
		} while(!stopMe);
		userInput.close();
		
		//wait for MarketNews instance to finish printing
		try{
			aObject.join();
		}
		catch(InterruptedException e){
			System.out.println("aObject.join(): Interrupted exception occurred");
		}
		
		//Say goodbye
		System.out.print("\nGood bye!");
	}
}
