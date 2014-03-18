package lesson13;

public class BikeOrder {
	
	static void validateOrder(String bikeModel, 
			int quantity) throws TooManyBikesException{
		if ((quantity > 100) || ((bikeModel != "Mini") && (quantity > 90))){
		throw new TooManyBikesException("Can not ship " +
			quantity + " bikes of the model " + bikeModel);
		}
	}

}
