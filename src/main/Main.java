package main;

import java.io.*;
import java.util.Scanner;

import PhoneOrientationML.*;

public class Main {
	public static void unknownDataOption(NNClassifier inputClassifier) {
		try {
			File inputFile = new File("resources/unknownData.txt");
			Scanner fileReader = new Scanner(inputFile);

			while (fileReader.hasNextLine()) {
				String data = fileReader.nextLine();
				System.out.println("data: " + data);
				String[] splitData = data.split(",");

				double newX = Double.parseDouble(splitData[0]);
				double newY = Double.parseDouble(splitData[1]);
				double newZ = Double.parseDouble(splitData[2]);
				Point newPoint = new Point(newX, newY, newZ);
				int predictedOrientation = inputClassifier.predict(newPoint);
				System.out.printf("Predicted Orientation: %d\n\n", predictedOrientation);
			}

			fileReader.close();

		} catch (FileNotFoundException error) {
			System.out.println("File Not Found Error.");
			error.printStackTrace();
		}
	}

	public static void main(String[] args) {
		NNClassifier newClassifier = new NNClassifier();
		// first train data
		newClassifier.training("resources/testingData.txt");
		System.out.println("Training Complete...\n");

		// then predict unknown file
		unknownDataOption(newClassifier);
		System.out.println("unknown data added to knowledge base...\n");

		// input from user
		Scanner inputScanner = new Scanner(System.in);
		boolean continueLoop = true;
		
		while (continueLoop) {
			double newX = 0;
			double newY = 0;
			double newZ = 0;
			try {
				String input;
				System.out.println("Please enter an X coordinate: ");
				input = inputScanner.nextLine();
				if ("q".equals(input)) {
					continueLoop = false;
					break;
				}
				newX = Double.parseDouble(input);
				
				System.out.println("\n");
				System.out.println("Please enter an Y coordinate: ");
				input = inputScanner.nextLine();
				if ("q".equals(input)) {
					continueLoop = false;
					break;
				}
				newY = Double.parseDouble(input);

				System.out.println("\n");
				System.out.println("Please enter an Z coordinate: ");
				input = inputScanner.nextLine();
				if ("q".equals(input)) {
					continueLoop = false;
					break;
				}
				newZ = Double.parseDouble(input);

				
			} catch (java.util.InputMismatchException error) {
				System.out.println("Incorrect input, please try again");
			}
			
			Point userPoint = new Point(newX, newY, newZ);
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
	}
}