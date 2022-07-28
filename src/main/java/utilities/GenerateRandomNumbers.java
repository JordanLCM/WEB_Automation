package utilities;

public class GenerateRandomNumbers {

	private static GenerateRandomNumbers genRN = new GenerateRandomNumbers();
	
	public static GenerateRandomNumbers getInstance() {
		return genRN;
	}
	
	public int generateRandomNumbers() {
		int min = 100000;
		int max = 123456;

		int randomNumber = (int) Math.floor(Math.random() * (max - min));
		return randomNumber;
	}
}
