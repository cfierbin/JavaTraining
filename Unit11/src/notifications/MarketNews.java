package notifications;

class MarketNews implements Updatable{
	
	String marketNews = null;
	
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
