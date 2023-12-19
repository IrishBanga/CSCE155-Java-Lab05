package unl.soc;


/**
 * A collection of utility methods for converting {@link RGB} values 
 *
 */
public class ColorUtils {

	/**
	 * Scales the given rgb integer component (on the scale [0, 255]) to a floating
	 * point number on the scale [0, 1].
	 *
	 * Note: this function is only included to demonstrate how to unit test floating
	 * point values. See the {@link ColorUtilsTester} for more.
	 */
	public static double rgbIntToFloat(int c) {
		return (double) c / 255;
	}

	/**
	 * Returns the maximum value among the three given integer values.
	 */
	public static int max(int x, int y, int z) {
		return Math.max(Math.max(x, y), z);
	}

	public static int min(int x, int y, int z) {
		return Math.min(Math.min(x, y), z);
	}

	/**
	 * Returns a gray-scaled {@link RGB} value of the given {@link RGB} values using the
	 * average technique.
	 *
	 * @param color
	 * @return
	 */
	public static RGB toGrayScaleAverage(RGB color) {
		//TODO: test this, it looks wrong!
		int result = (int)Math.round((double)(color.getRed() + color.getGreen() + color.getBlue()) / 3);
		result=(result>255)?(255):(result);
		RGB gray = new RGB(result, result, result);
		return gray;
	}


	public static RGB toGrayScaleLightness(RGB color) {
		int result = (int)Math.round((double)(max(color.getRed(),color.getGreen(),color.getBlue())+min(color.getRed(),color.getGreen(),color.getBlue())) / 2);
		result=(result>255)?(255):(result);
		RGB gray = new RGB(result, result, result);
		return gray;
	}

	public static RGB toGrayScaleLuminosity(RGB color) {
		int result = (int)Math.round((double)(0.21*color.getRed() + 0.72*color.getGreen() + 0.07*color.getBlue()));
		result=(result>255)?(255):(result);
		RGB gray = new RGB(result, result, result);
		return gray;
	}

	public static RGB toSepia(RGB color) {
		int R = (int)Math.round((double)(0.393*color.getRed() + 0.769*color.getGreen() + 0.189*color.getBlue()));
		int G= (int)Math.round((double)(0.349*color.getRed() + 0.686*color.getGreen() + 0.168*color.getBlue()));
		int B= (int)Math.round((double)(0.272*color.getRed() + 0.534*color.getGreen() + 0.131*color.getBlue()));
		R=(R>255)?(255):(R);
		G=(G>255)?(255):(G);
		B=(B>255)?(255):(B);
		RGB sepia = new RGB(R,G,B);
		return sepia;
	}
}
