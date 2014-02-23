package immutableStrings;

public class TestImmutable {

	public static void main(String[] args) {
		
		String gfriend = "Masha";
		/*
		if (gfriend == "Masha") { // true or false?
			}
		*/
		
		System.out.println((gfriend == "Masha")?"(gfriend == \"Masha\") is true":"(gfriend == \"Masha\") is false");
				
		/*
		String gfriend1 = new String ("Natasha");	
		String gfriend2 = new String ("Natasha");
		*/
		
		String gfriend1 = "Natasha";	
		String gfriend2 = "Natasha";
		
		/*
		if (gfriend1 == gfriend2){ // true or false?
			
		}
		*/
		
		System.out.println((gfriend1 == gfriend2)?"(gfriend1 == gfriend2) is true":"(gfriend1 == gfriend2) is false");

	}
	}


