package PhoneOrientationML;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class BaseClassifier {

	/**
	 * Training for the ML before predictions can occur
	 * 
	 * @param filePath - name of file with known data / knowledge base
	 */
	public abstract void training(String filePath);

	/**
	 * Predict given the inputed point
	 * 
	 * @param inputPoint - input unknown point
	 * @return integer value associated with orientation
	 */
	public abstract int predict(Point inputPoint);
	
	//Functions for training and running on unknown data for any children of BaseClassifier...

	/**
	 * function to train classifier, notifies upon completion
	 * 
	 * @param inputClassifier - classifier from main without any training data
	 */
	public void trainDataOption(String filePath) {
		this.training(filePath);
		System.out.println("Training Complete...\n");
	}

	/**
	 * function for the unknown data file, prints out predictions
	 * 
	 * @param inputClassifier - classifier from main that already has training data
	 *                        in it
	 */
	public void unknownDataOption(String filePath) {
		try {
			File inputFile = new File(filePath);
			Scanner fileReader = new Scanner(inputFile);

			while (fileReader.hasNextLine()) {	//keep reading lines until end of file
				String data = fileReader.nextLine();
				System.out.println("data: " + data);
				String[] splitData = data.split(",");	//split on , into an array of 3

				double newX = Double.parseDouble(splitData[0]);	//parse inputs
				double newY = Double.parseDouble(splitData[1]);
				double newZ = Double.parseDouble(splitData[2]);
				Point newPoint = new Point(newX, newY, newZ);
				
				int predictedOrientation = this.predict(newPoint);	//predict given point from unknown file
				
				System.out.printf("Predicted Orientation: %d\n\n", predictedOrientation);
			}

			fileReader.close();

		} catch (FileNotFoundException error) {	//in case file doesn't exist
			System.out.println("File Not Found Error.");
			error.printStackTrace();
		}
	}
}