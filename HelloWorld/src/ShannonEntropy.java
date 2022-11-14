
public class ShannonEntropy {

	public static void main(String[] args) {
		int m = Integer.parseInt(args[0]);
		double H = 0;
		int[] values = new int[m];
		int noOfSamples = 0;
		while (!StdIn.isEmpty()) {
			values[StdIn.readInt()-1] += 1;
			noOfSamples++;
		}
		for (int i = 0; i < m; i++) {
			
			if (values[i] != 0) {
				double pi = (double)(values[i]) / noOfSamples;
				H += - pi * Math.log(pi) / Math.log(2);
			}
		}
		StdOut.printf("%.4f", H);

	}

}
