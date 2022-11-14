
public class RevesPuzzle {

	static void reves(int n, char a, char b, char c, char d) {
		if (n == 0) return; 
        if (n == 1) { 
            StdOut.println("Move disk " + n + " from " + a + " to " + b);
            return;
        }
        if (n>30) return;
        reves(n - 2, a, c, d, b); 
        System.out.println("Move disk " + (n - 1) + " from " + a + " to " + d); 
        System.out.println("Move disk " + n + " from " + a + " to " + b); 
        System.out.println("Move disk " + (n - 1) + " from " + d + " to " + b); 
        reves(n - 2, c, b, a, d); 
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		reves(n, 'A', 'D', 'B', 'C');  
	}

}
