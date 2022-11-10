public class RandomWalkers {

	public static void main(String[] args) {
		int r = Integer.parseInt(args[0]);
		int trials = Integer.parseInt(args[1]);
		int totalNoOfSteps = 0;
		
		for (int t = 0; t < trials; t++) {
			int x = 0;
			int y = 0;
			int noSteps = 0;
			while (Math.abs(x) + Math.abs(y) < r) {
				double step = Math.random() * 4;
				if (step < 1) {
					x += 1;
				}else
					if (step < 2) {
						y += 1;
					}else
						if (step < 3) {
							x -= 1;
						}else
							if (step < 4) {
								y -= 1;
							}
				noSteps++;
		
			}
			totalNoOfSteps += noSteps;
		}
		System.out.println("average number of steps = " + (double)(totalNoOfSteps) / trials );
	}

}
