package lesson13;

public class BikeOrder {
	
	static void validateOrder(String bikeModel, 
			int quantity) throws TooManyBikesException{
		
		throw new TooManyBikesException("Can not ship " +
			quantity + " bikes of the model " + bikeModel);
		
	}

}
