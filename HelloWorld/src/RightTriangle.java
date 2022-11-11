public class RightTriangle {

	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);
		boolean isTriangle = (a>0 && b>0 && c>0);
		
		int hypotenuse = Math.max(Math.max(a, b),c);
		int sumOfSquares = a*a+b*b+c*c;
		isTriangle = isTriangle && (2*hypotenuse*hypotenuse == sumOfSquares);

		System.out.println(isTriangle);
		

	}

}
