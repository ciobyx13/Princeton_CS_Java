
public class ColorHSB {
	
	public final int hue;
	public final int sat;
	public final int value;
	
    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
    	if (!(0<=h && h<=359 && 0<=s && s<=100 && 0<=b && b<=100)) throw new IllegalArgumentException("Arguments out of range");
    	hue = h;
    	sat = s;
    	value = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
    	return ("("+hue+","+sat+","+value+")");
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
    	return (sat == 0 || value == 0);
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
    	if (that == null) throw new IllegalArgumentException();
    	return (int) (Math.min(Math.pow(hue-that.hue, 2), Math.pow(360-hue-that.hue, 2))+Math.pow(sat-that.sat, 2)+Math.pow(value-that.value, 2));
    }

    // Sample client (see below).
	public static void main(String[] args) {
		int h = Integer.parseInt(args[0]);
		int s = Integer.parseInt(args[1]);
		int v = Integer.parseInt(args[2]);
		
		ColorHSB myColor = new ColorHSB(h, s, v);
		
		ColorHSB[] colors = new ColorHSB[1500];
		int index = 0;
		int maxIndex = 0;
		int distance=Integer.MAX_VALUE;
		String closestColor = null;

		while (!StdIn.isEmpty()) {
			String name = StdIn.readString();
			int h2 = StdIn.readInt();
			int s2 = StdIn.readInt();
			int v2 = StdIn.readInt();
			colors[index] = new ColorHSB(h2, s2, v2);
			int currentDistance = myColor.distanceSquaredTo(colors[index]); 
			if (currentDistance < distance) {
				distance = currentDistance;
				maxIndex = index;
				closestColor = name;
			}
			//StdOut.println(name+" "+ colors[index].toString()+" "+currentDistance);
			index++;
		}
		
		StdOut.println(closestColor+ " "+colors[maxIndex].toString());
		

	}

}
