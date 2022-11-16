public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
    	int n = a.length;
    	long count=0;
    	for (int i=0; i<n; i++) {
    		for (int j=i+1; j<n; j++) {
    			if (a[i]>a[j]) count++;
    		}
    	}
    	return count;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
    	int[] a = new int[n];
    	for (int i=0; i<n; i++) {
    		a[i] = i;
    	}
    	
		int startIndex = 0;
		int endIndex = n-1;
		while (k > 0) {
			int index;
			if ((k+1)/2 > endIndex-startIndex) index = startIndex;
			else
			 index = (int) (endIndex-(k+1)/2);

			int aux = a[index];
			a[index] = a[endIndex];
			a[endIndex] = aux;

			k -= 2*(endIndex-startIndex)-1;
			startIndex++;
			endIndex--;
		}
		if (-k % 2 == 1) 
			for (int i=0; i<n-1; i++) {
				if (a[i]<a[i+1]) {
					int aux = a[i];
					a[i] = a[i+1];
					a[i+1] = aux;	
					break;
				}
			}
		return a;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);

		int[] a = generate(n, k);
		for (int i=0; i<a.length; i++) {
			StdOut.print(a[i]+" ");
		}
		StdOut.println();
		
	}

}
