
public class Ramanujan {
    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
    	int numberOfSums = 0;
    	for (long i=0; i<Math.cbrt(n); i++) {
    		 double diff = Math.cbrt(n - i * i * i);
				if (Math.floor(diff) == diff && i < diff) {
					numberOfSums++;
					StdOut.println(i + "^3+" + diff + "^3");
					if (numberOfSums == 2)
						return true;
				}
    	}
    	return false;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
	public static void main(String[] args) {
		long n = Long.parseLong(args[0]);
		n = 700165097;
		StdOut.println(isRamanujan(n));
	}

}
