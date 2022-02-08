package PhoneOrientationML;

import java.util.Vector;

public interface BaseClassifier {

	/**
	 * Training for the ML before predictions can occur
	 * @param fileName - name of file with known data / knowledge base
	 * @param points - points for training
	 */
	public void training(String fileName, Vector<Point> points);
	
	/**
	 * Predict given the inputed point
	 * 
	 * @param point - input point
	 * @param x - input X coordinate
	 * @param y - input Y coordinate
	 * @param z - input Z coordinate
	 * @return integer value associated with orientation
	 */
	public int predict(Vector<Point> point,int x, int y, int z);
}
