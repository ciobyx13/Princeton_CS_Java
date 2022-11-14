
public class WorldMap {

	public static void main(String[] args) {
		int width = StdIn.readInt();
		int height = StdIn.readInt();
		StdDraw.setCanvasSize(width, height);
		StdDraw.setXscale(0, width);
		StdDraw.setYscale(0, height);
		
		while (!StdIn.isEmpty()) {
			String region = StdIn.readString();
			int n = StdIn.readInt();
			double[] polygonX = new double[n];
			double[] polygonY = new double[n];
			for (int i = 0; i < n; i++) {
				polygonX[i] = StdIn.readDouble();
				polygonY[i] = StdIn.readDouble();
			}
			StdDraw.polygon(polygonX, polygonY);
		}

	}

}
