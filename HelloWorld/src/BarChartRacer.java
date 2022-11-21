import java.util.Arrays;

public class BarChartRacer {

	public static void main(String[] args) {
		String filename = args[0];
		//filename = "src\\game-of-thrones.txt";
		int k = Integer.parseInt(args[1]);
		In input = new In(filename);
		
		String title = input.readLine();
		String xAxisLabel = input.readLine();
		String source = input.readLine();
		input.readLine();
		BarChart chart = new BarChart(title, xAxisLabel, source);
		StdDraw.setCanvasSize(1000, 700);
		StdDraw.enableDoubleBuffering();
		
		while (input.hasNextLine()) {
			chart.reset();
			StdDraw.clear();
			int n = Integer.parseInt(input.readLine());
			int noOfBars = Math.min(k, n);
			String date = null;
			Bar[] bars = new Bar[n];
			String line;
			for (int i = 0; i < n; i++) {
				do{
					line = input.readLine();
				} while (line == "");
				String[] items = line.split(",");
				date = items[0];
				String name = items[1];
				int value = Integer.parseInt(items[3]);
				String category = items[4];
				bars[i] = new Bar(name, value, category);
			}
			Arrays.sort(bars);
			for (int i = n-1; i > n-1-noOfBars; i--) {
				chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
			}
			
			chart.setCaption(date);
			chart.draw();
			StdDraw.show();
			StdDraw.pause(10);
			input.readLine();
			
		}
	}

}
