package notifications;

class MarketNews extends Thread implements Updatable{
	
	private String marketNews = null;
	private	volatile boolean stopMe	= false;	
	
	public void	stopMe() {	
		stopMe = true;	
	}	

	public void run(){
	
	do{
	
		getNews();
	
	} while(!stopMe);
	
	}
	
	synchronized void getNews(){
		
		try{
			wait();
		}
		catch(InterruptedException e){
			System.out.println("getNews(): InterruptedException");
		}
		
		System.out.println(marketNews);
				
	}	
	
	public void setData (String news){
		marketNews = news;
	}
	
}
