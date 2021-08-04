package casestudy;

public class TrainNotFoundException extends Exception{	
	@Override
	public String getMessage() {
		return "Train with given number does not exist";
	}

}
