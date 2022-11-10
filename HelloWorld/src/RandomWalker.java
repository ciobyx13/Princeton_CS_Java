public class RandomWalker {

	public static void main(String[] args) {
		int r = Integer.parseInt(args[0]);
		int x = 0;
		int y = 0;
		int noSteps = 0;
		System.out.println("(" + x + ", " + y + ")");
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
			System.out.println("(" + x + ", " + y + ")");
	
		}
		System.out.println("steps = " + noSteps);
	}

}
