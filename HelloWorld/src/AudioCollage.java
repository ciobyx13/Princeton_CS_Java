
public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
    	double[] amp = new double[a.length];
    	for (int i = 0; i < a.length; i++) {
    		amp[i] = a[i] * alpha;
    	}
    	return amp;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
    	int n = a.length;
    	double[] reverse = new double[n];
    	for (int i = 0; i < n; i++) {
    		reverse[i] = a[n-i-1];
    	}
    	return reverse;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
    	int n = a.length;
    	int m = b.length;
    	double[] merged = new double[m + n];
    	for (int i = 0; i < n; i++) {
    		merged[i] = a[i];
    	}
    	for (int i = 0; i < m; i++) {
    		merged[i+n] = b[i];
    	}
    	return merged;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
    	int n = a.length;
    	int m = b.length;
    	double[] mixed;
    	if (n >= m) {
    		mixed = new double[n];
    		for (int i = 0; i < n; i++) {
        		mixed[i] = a[i];
        		if (i < m) mixed[i] += b[i];
        	}
    	} else {
    		mixed = new double[m];
        	for (int i = 0; i < m; i++) {
        		mixed[i] = b[i];
        		if (i < n) mixed[i] += a[i];
        	}
    	}

    	return mixed;	
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
    	int n = a.length;
    	int m = (int) (n / alpha);
    	double[] output = new double[m];
    	for (int i = 0; i < m; i++) {
    		output[i] = a[(int) (i * alpha)];
    	}
    	
    	return output;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
		double[] song1 = StdAudio.read("src\\piano.wav");
		double[] song2 = StdAudio.read("src\\harp.wav");
		StdAudio.play(song1);
		StdAudio.play(song2);
		StdAudio.play(amplify(song2, 2.5));
		StdAudio.play(reverse(song2));
		StdAudio.play(merge(song1, song2));
		StdAudio.play(mix(song1, song2));
		StdAudio.play(changeSpeed(song2, 1.2));

	}

}
