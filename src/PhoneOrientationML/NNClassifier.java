package PhoneOrientationML;

import java.util.Vector;

public class NNClassifier implements BaseClassifier{
	
	String fileName;
	
	/**
	 * knowledge base for ML "known points"
	 */
	Vector<Point> points;
	
	public NNClassifier() {
		
	}

	public void training(String fileName, Vector<Point> points) {
		
	}
	
	public int predict(Vector<Point> point,int x, int y, int z) {
		return 1;
	}
}
