import java.util.Random;

public class TestDemo {
	
	//1. method to add two positive integers
	public int addPositive(int a, int b) {
		int c = a + b;
		if( (a > 0) && (b > 0)) {
			System.out.println("The answer to " + a + " + " + b + " is " + c);
		} else if (a <= 0 || b <= 0) {
			//throw exception if one or both integers are not positive
			throw new IllegalArgumentException("\nBoth parameters must be positive!");
		}
		return c;
	}
	
	//3. created a new method that would divide two doubles
	public double divideTwoDoubles(double a, double b) {
		double c = a / b;
		if( b != 0) {
			System.out.println("The answer to " + a + " divided by " + b + " is " + c);
		} else if (b == 0) {
			throw new IllegalArgumentException("\nThe divisor cannot be zero!");
		}
		return c;
	}
	
	//4. method to demonstrate Mockito
	public int randomNumberSquared() {
		int rand = getRandomInt();
		return (rand * rand);
	}

	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}

}
