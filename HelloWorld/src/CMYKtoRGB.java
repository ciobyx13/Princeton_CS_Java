public class CMYKtoRGB {

	public static void main(String[] args) {
		double cyan = Double.parseDouble(args[0]);
		double magenta = Double.parseDouble(args[1]);
		double yellow = Double.parseDouble(args[2]);
		double black = Double.parseDouble(args[3]);
		
		double white = 1-black;
		int red = (int) (255*white*(1-cyan));
		int green = (int) (255*white*(1-magenta));
		int blue = (int) (255*white*(1-yellow));
		
		System.out.println("red   = "+red);
		System.out.println("green = "+green);
		System.out.println("blue  = "+blue);
        int[] b = { 1, 2, 3 };
        int[] c = b;
        c[0] += b[2];
        c[1] += b[1];
        c[2] += b[0];
        System.out.println(c[0] + c[1] + c[2]);

	}

}
