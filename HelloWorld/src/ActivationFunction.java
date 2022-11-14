
public class ActivationFunction {
	
    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
    	if (x > 0) return 1.0;
    	if (x < 0) return 0.0;
    	if (x == Double.NaN) return Double.NaN;
    	
    	return 0.5;
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
    	return 1.0 / (1 + Math.exp(-x));
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
    	if (x == Double.NaN) return 1.0;
    	if (x == Double.POSITIVE_INFINITY) return 1.0;
    	if (x == Double.MAX_VALUE) return 1.0;
    	if (x == Double.NEGATIVE_INFINITY) return -1.0;
    	if (x == Double.MIN_VALUE) return -1.0;
    	return (Math.exp(x) - Math.exp(-x))/(Math.exp(x) + Math.exp(-x));
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
    	if (x == Double.POSITIVE_INFINITY) return 1.0;
    	if (x == Double.MAX_VALUE) return 1.0;
    	if (x == Double.NEGATIVE_INFINITY) return -1.0;
    	if (x == Double.MIN_VALUE) return -1.0;
    	return x / (1 + Math.abs(x));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
    	if (x == Double.NaN) return 1.0;
    	if (x <= - 2) return -1.0;
    	if (x > - 2 && x < 0) return x + x * x / 4;
    	if (x >= 0 && x < 2) return x - x * x / 4;
    	return 1.0;
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
	public static void main(String[] args) {
		double x = Double.parseDouble(args[0]);
		StdOut.println("heaviside(" + x + ") = " + heaviside(x));
		StdOut.println("sigmoid(" + x + ") = " + sigmoid(x));
		StdOut.println("tanh(" + x + ") = " + tanh(x));
		StdOut.println("softsign(" + x + ") = " + softsign(x));
		StdOut.println("sqnl(" + x + ") = " + sqnl(x));

	}

}
