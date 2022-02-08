package PhoneOrientationML;

/**
 * Basic classifier with only print function name instead of implementation
 * @author anthony
 *
 */
public class AnotherClassifier extends BaseClassifier {

	public void training(String filePath) {
		System.out.println("public void training(String filePath)");
	}

	public int predict(Point inputPoint) {
		System.out.println("public void training(String fileName)");
		return 1;
	}

}