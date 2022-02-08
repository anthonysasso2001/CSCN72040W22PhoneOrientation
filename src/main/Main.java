package main;

import java.io.*;
import java.util.Scanner;

import PhoneOrientationML.*;

public class Main {

	public static void main(String[] args) {
		NNClassifier newClassifier = new NNClassifier();

		newClassifier.training("resources/testingData.txt");
		System.out.println("Training Complete...\n");

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
				int predictedOrientation = newClassifier.predict(newPoint);
				System.out.printf("Predicted Orientation: %d\n\n", predictedOrientation);
			}

			fileReader.close();

		} catch (FileNotFoundException error) {
			System.out.println("File Not Found Error.");
			error.printStackTrace();
		}
	}

}