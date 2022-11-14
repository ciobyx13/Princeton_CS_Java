
public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
		
		if (n == 0) return 1;
		
		long[] polinom = new long[2 * n + 1];
		long aux[] = new long[2 * n + 1];
		polinom[0] = 1;
		polinom[1] = 0;
		polinom[2] = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < (2 * i + 3); j++) {
				aux[j] = polinom[j];
			}
			//j == 1
			polinom[1] += aux[0];
			for (int j=2; j<2*i + 3; j++) {
				polinom[j] += aux[j-1] + aux[j-2];
			}
		}
		if (n+k<2*n+1 && n+k>=0) return polinom[n+k];
		else return 0;
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		
		StdOut.println(trinomial(n, k));


	}

}
