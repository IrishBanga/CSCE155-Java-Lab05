
public class Sine {

	/**
	 * This method computes the factorial, n!
	 * @param n
	 * @return
	 */
	public static long factorial(int n) {
		long result = 1;
		for(int i=2; i<=n; i++) {
			result *= i;
		}
		return result;
	}

	public static void main(String args[]) {
		
		if(args.length != 3) {
			System.err.println("Usage: Sine x n");
			System.exit(1);
		}

		double x = Double.parseDouble(args[0]);
		int n = Integer.parseInt(args[1]);
		
		double result = 0.0;

		//compute sin(x) using a Taylor series out to n terms
		int sign = 1;
		double sum = 0.0;
		for(int i=0; i<n; i++) {
			sum += (sign * Math.pow(x, 2*i+1) / factorial(2*i+1));
			sign *= -1;
		}

		result = sum;
		System.out.printf("sin(%f) = %f\n", x, result);

	}

}
