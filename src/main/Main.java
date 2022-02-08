package main;

import java.util.Scanner;

import PhoneOrientationML.*;

public class Main {

	public static void main(String[] args) {

		NNClassifier newClassifier = new NNClassifier(); // classifier used in program

		// first train data
		newClassifier.trainDataOption("resources/testingData.txt");

		// then predict unknown file
		newClassifier.unknownDataOption("resources/unknownData.txt");

		// now input from user
		Scanner inputScanner = new Scanner(System.in);
		boolean continueLoop = true;

		while (continueLoop) { // keep looping until they exit...
			double newX = 0;
			double newY = 0;
			double newZ = 0;

			try { // using try in case of weird input
				String input;
				System.out.println("Please enter an X coordinate: ");
				input = inputScanner.nextLine();
				if ("q".equals(input)) {	//check if they want to exit
					continueLoop = false;
					break;
				}
				newX = Double.parseDouble(input);

//				System.out.println("\n");
				System.out.println("Please enter an Y coordinate: ");
				input = inputScanner.nextLine();
				if ("q".equals(input)) {	//check if they want to exit
					continueLoop = false;
					break;
				}
				newY = Double.parseDouble(input);

//				System.out.println("\n");
				System.out.println("Please enter an Z coordinate: ");
				input = inputScanner.nextLine();
				if ("q".equals(input)) {	//check if they want to exit
					continueLoop = false;
					break;
				}
				newZ = Double.parseDouble(input);

			} catch (java.lang.NumberFormatException error) {
				System.out.println("Incorrect input, please try again\n\n");
			}

			System.out.println("\n");

			Point userPoint = new Point(newX, newY, newZ); // create point from user input

			//print output for options
			int outputPrediction = newClassifier.predict(userPoint);
			String orientation = new String();
			if (1 == outputPrediction) {
				orientation = "Face Up";
			} else if (2 == outputPrediction) {
				orientation = "Face Down";
			} else if (3 == outputPrediction) {
				orientation = "Portrait";
			} else if (4 == outputPrediction) {
				orientation = "Portrait, Upside Down";
			} else if (5 == outputPrediction) {
				orientation = "Landscape Left";
			} else if (6 == outputPrediction) {
				orientation = "Landscape Right";
			} else {
				orientation = "Unknown";
			}

			System.out.println("Phone Orientation = " + orientation + "\n");
		}
		//close scanner after no more inputs are needed
		inputScanner.close();
	}
}