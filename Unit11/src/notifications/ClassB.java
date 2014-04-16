package notifications;

class ClassB extends Thread {
	
	private Updatable parent = null;
	
	private	volatile boolean stopMe	= false;	
	
	public void	stopMe() {	
		stopMe = true;	
	}
	
	ClassB(Updatable caller, String threadName){
		super(threadName);
		parent = caller; //store reference to caller
	}
	
	public void run(){
		
		do{
			//get some data
		String someData = String.valueOf((int)(100*Math.random()));
		try{
			sleep((int)(1000*Math.random()));
		}
		catch(InterruptedException e){
			System.out.println("Thread.sleep InterruptedException");
			}

		synchronized(parent){
			parent.setData(Thread.currentThread().getName() + ": " + someData);
			parent.notify();
		}
		} while (!stopMe);
	}

}
