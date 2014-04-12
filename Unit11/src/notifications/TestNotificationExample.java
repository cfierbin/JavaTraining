package notifications;

public class TestNotificationExample {

	public static void main(String[] args) {
		MarketNews aObject = new MarketNews();
		ClassB myB1 = new ClassB(aObject, "ORCL");
		myB1.start();
		ClassB myB2 = new ClassB(aObject, "AMZN");
		myB2.start();
		do {
			aObject.getNews();
		} while(true);
	}

}
