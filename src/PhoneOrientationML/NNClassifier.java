package PhoneOrientationML;

import java.util.*;
import java.io.*;

public class NNClassifier extends BaseClassifier {

	/**
	 * knowledge base for ML "known points"
	 */
	ArrayList<Point> points;

	/**
	 * Constructor for NNClassifier, allocates array list
	 */
	public NNClassifier() {
		this.points = new ArrayList<Point>();
	}

	public void training(String filePath) {
		try {
			File inputFile = new File(filePath);
			Scanner fileReader = new Scanner(inputFile);

			while (fileReader.hasNextLine()) {
				String data = fileReader.nextLine();
//				System.out.println("data: " + data);
				String[] splitData = data.split(",");	//split on , into an array of 3

				double newX = Double.parseDouble(splitData[0]);	//parse inputs
				double newY = Double.parseDouble(splitData[1]);
				double newZ = Double.parseDouble(splitData[2]);
				int newOrientation = Integer.parseInt(splitData[3]);

				Point newPoint = new Point(newX, newY, newZ, newOrientation);
//				System.out.printf("X: %f, Y: %f, Z: %f, Orientation: %d\n", newX, newY, newZ, newOrientation);
				this.points.add(newPoint);
			}

			fileReader.close();

		} catch (FileNotFoundException error) {
			System.out.println("File Not Found Error.");
			error.printStackTrace();
		}
	}

	/**
	 * get point and compare to all in set
	 * @param inputPoint
	 */
	private void getDistance(Point inputPoint) {
		for (Point currentPoint : this.points) {
			currentPoint.setDistance(Math.sqrt(Math.pow((currentPoint.getxVal() - inputPoint.getxVal()), 2)
					+ Math.pow((currentPoint.getyVal() - inputPoint.getyVal()), 2)
					+ Math.pow((currentPoint.getzVal() - inputPoint.getzVal()), 2)));
//			System.out.printf("distance: %f\n", currentPoint.distance);
		}
	}

	/**
	 * sorts points for predict function and compare to each other by overriding comparator operator
	 * @author anthony
	 *
	 */
	private class sortPoints implements Comparator<Point> {

		@Override
		public int compare(Point a, Point b) {
			return Double.compare(a.getDistance(),b.getDistance());	//use built in compare for two doubles
		}

	}

	public int predict(Point inputPoint) {

		this.getDistance(inputPoint);
		Collections.sort(this.points, new sortPoints());
//		for(Point currentPoint:this.points) {
//			System.out.printf("sortedDistance: %f\n",currentPoint.distance);
//		}
		inputPoint.setOrientation(this.points.get(0).getOrientation());
		return inputPoint.getOrientation();
	}
}