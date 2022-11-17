import java.awt.Color;

public class KernelFilter {
	
	 // Applies kernel to image
    public static Picture applyKernel(Picture picture, double[][] kernel) {
    	Picture output = new Picture(picture);
    	int midPoint = kernel.length/2;
    	for (int i=0; i<picture.height(); i++) {
        	for (int j=0; j<picture.width(); j++) {
        		int red = 0;
        		int green = 0;
        		int blue = 0;
        		int iWrapped;
        		int jWrapped;
            	for (int k1=0; k1 < kernel.length; k1++) {
                	for (int k2=0; k2 < kernel[0].length; k2++) {
                		iWrapped = i-midPoint+k1;
                		jWrapped = j-midPoint+k2;
                		if (iWrapped < 0) iWrapped += picture.height();
                		if (iWrapped > picture.height()-1) iWrapped -= picture.height();
                		if (jWrapped < 0) jWrapped += picture.width();
                		if (jWrapped > picture.width()-1) jWrapped -= picture.width();
                		
                		red += kernel[k1][k2] * picture.get(iWrapped, jWrapped).getRed();
                		green += kernel[k1][k2] * picture.get(iWrapped, jWrapped).getGreen();
                		blue += kernel[k1][k2] * picture.get(iWrapped, jWrapped).getBlue();
                	}
            	}
            	red = Math.round(red);
            	green = Math.round(green);
            	blue = Math.round(blue);
            	if (red < 0) red = 0;
            	if (red >255) red = 255;
            	if (green < 0) green = 0;
            	if (green >255) green = 255;
            	if (blue < 0) blue = 0;
            	if (blue >255) blue = 255;
            	output.set(i, j, new Color(red, green, blue));
        	}	
    	}
    	return output;
    }

	 // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
    	double[][] kernel = new double[][] {
            new double[] { 0, 0, 0},
            new double[] { 0, 1, 0},
            new double[] { 0, 0, 0}
        };
        return applyKernel(picture, kernel);
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
    	double[][] kernel = new double[][] {
            new double[] { 0.0625, 0.125, 0.0625},
            new double[] { 0.125, 0.25, 0.125},
            new double[] { 0.0625, 0.125, 0.0625}
        };
        return applyKernel(picture, kernel);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
    	double[][] kernel = new double[][] {
            new double[] { 0, -1, 0},
            new double[] { -1, 5, -1},
            new double[] { 0, -1, 0}
        };
        return applyKernel(picture, kernel);	
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
    	double[][] kernel = new double[][] {
            new double[] { -1, -1, -1},
            new double[] { -1, 8, -1},
            new double[] { -1, -1, -1}
        };
        return applyKernel(picture, kernel);	
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
    	double[][] kernel = new double[][] {
            new double[] { -2, -1, 0},
            new double[] { -1, 1, 1},
            new double[] { 0, 1, 2}
        };
        return applyKernel(picture, kernel);		
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
    	double[][] kernel = new double[][] {
            new double[] { 1, 0, 0, 0, 0, 0, 0, 0, 0},
            new double[] { 0, 1, 0, 0, 0, 0, 0, 0, 0},
            new double[] { 0, 0, 1, 0, 0, 0, 0, 0, 0},
            new double[] { 0, 0, 0, 1, 0, 0, 0, 0, 0},
            new double[] { 0, 0, 0, 0, 1, 0, 0, 0, 0},
            new double[] { 0, 0, 0, 0, 0, 1, 0, 0, 0},
            new double[] { 0, 0, 0, 0, 0, 0, 1, 0, 0},
            new double[] { 0, 0, 0, 0, 0, 0, 0, 1, 0},
            new double[] { 0, 0, 0, 0, 0, 0, 0, 0, 1},
        };
    	for (int i=0; i<kernel.length; i++) {
        	for (int j=0; j<kernel[0].length; j++) {
        		kernel[i][j] /= 9;
        	}
    	}
        
        return applyKernel(picture, kernel);		
    }

    // Test client (ungraded).
    public static void main(String[] args) {
		Picture testPicture = new Picture("src\\baboon.png");
		testPicture.show();
		identity(testPicture).show();
		gaussian(testPicture).show();
		sharpen(testPicture).show();
		laplacian(testPicture).show();
		emboss(testPicture).show();
		motionBlur(testPicture).show();
	}

}
