package function;

import java.util.Random;

public class GenerateRandomPosition {
	
	public static int generate() {
	    int value = -100 + (int) (Math.random() * ((100 - (-100)) + 1));
	    return value;
	}
	public static int generate(int min, int max) {
//		int value = min + (int)(Math.random() * max);
		int value = new Random().nextInt(max - min + 1) + min ;
		return value;
	}
	
}
