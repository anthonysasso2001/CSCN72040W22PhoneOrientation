package PhoneOrientationML;

public interface BaseClassifier {

	/**
	 * Training for the ML before predictions can occur
	 * 
	 * @param fileName - name of file with known data / knowledge base
	 */
	public void training(String fileName);

	/**
	 * Predict given the inputed point
	 * 
	 * @param inputPoint - input unknown point
	 * @return integer value associated with orientation
	 */
	public int predict(Point inputPoint);
}