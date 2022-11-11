
public class Birthday {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int trials = Integer.parseInt(args[1]);
		int[] statistics = new int[n];

		for (int t = 0; t < trials; t++) {
			boolean [] birthdays = new boolean[n];
			int birthday = ((int) (Math.random()*(n)));
			for (int j = 1; j < n; j++) {
				if (birthdays[birthday] == true) {
					statistics[j]++;
					break;
				}else
				{
					birthdays[birthday] = true;
				}
				birthday = ((int) (Math.random()*n));
			}
		}
		double percentage = 0;
		for (int i = 1; i < n; i++) {
			percentage += (double) (statistics[i]) / trials;
			System.out.println(i + " " + statistics[i] + " " + percentage);
			if (percentage > 0.5) break;
		}
	}

}
