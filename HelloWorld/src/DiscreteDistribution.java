
public class DiscreteDistribution {

	public static void main(String[] args) {
		int m = Integer.parseInt(args[0]);
		int Sn = 0;
		int n = args.length;
		int[] Sums = new int[n];
		
		for(int i = 1; i < n; i++) {
			Sn += Integer.parseInt(args[i]);
			Sums[i] = Sn;
		}
		for(int i = 0; i < m; i++) {
			int rand = (int) (Math.random() * Sn);
			for (int j = 0; j < n; j++) {
				if (Sums[j] > rand) {
					System.out.print(j + " ");
					break;
				}
			}
		}
		

	}

}
