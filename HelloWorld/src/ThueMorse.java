
public class ThueMorse {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int m = 1;
		while (m < n ) {
			m *= 2;
		}
		int[] seq = new int[m];
		int index = 1;
		while (index <= m) {
			for (int j = index/2; j<index; j++) {
				seq[j] = Math.abs(seq[j-index/2]-1);
			}
			index *=2;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (seq[i] == seq[j]) System.out.print("+  ");
				else System.out.print("-  ");
			}
			System.out.println();
		}
			
	}

}
