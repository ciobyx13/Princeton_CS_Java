
public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
    	int size = 0;
    	int n = a.length;
    	int[][] b = new int[n][n];
    	for (int i=0; i<n; i++) {
    		int numberOfConsecutives = 0;
        	for (int j=0; j<n; j++) {
        		if (a[i][j] == 1) numberOfConsecutives++;
        		else numberOfConsecutives = 0;
        		b[i][j] = numberOfConsecutives;
        	}
    	}
    	for (int j=0; j<n; j++) {
        	for (int i=0; i<n; i++) {
	    		while (i<n-1 && b[i][j] > size) {
	    			int k = i;
	    			int currentSize = 1;
	    			while (k < n-1 && b[k+1][j] >= b[k][j] && currentSize < b[i][j]) {
	    				currentSize++;
	    				if (currentSize > size) size = currentSize;
	    				k++;
	    			}
	    		i++;
	    		}
        	}
    	}
        return size;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
		int n = StdIn.readInt();
		int[][] a = new int[n][n];
    	for (int i=0; i<n; i++) {
        	for (int j=0; j<n; j++) {
        		a[i][j]= StdIn.readInt();
        	}
    	}
        	StdOut.println(size(a));

	}

}
