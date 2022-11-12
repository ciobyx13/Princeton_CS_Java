
public class ShannonEntropy {

	public static void main(String[] args) {
		int m = Integer.parseInt(args[0]);
		double H = 0;
		int[] values = new int[m];
		double[] pi = new double[m];
		for (int i = 0; i < m; i++) {
			values[StdIn.readInt()-1] += 1;
		}
		for (int i = 0; i < m; i++) {
			
			if (values[i] != 0) {
				pi[i] = (double)(values[i]) / m;
				H += - pi[i] * Math.log(pi[i]) / Math.log(2);
			}
		}
		StdOut.println(H);

	}

}
