package PhoneOrientationML;

import java.util.*;
import java.io.*;

public class NNClassifier implements BaseClassifier {

	/**
	 * knowledge base for ML "known points"
	 */
	ArrayList<Point> points;

	public NNClassifier() {
		this.points = new ArrayList<Point>();
	}

	public void training(String filePath) {
		try {
			File inputFile = new File(filePath);
			Scanner fileReader = new Scanner(inputFile);

			while (fileReader.hasNextLine()) {
				String data = fileReader.nextLine();
				//System.out.println("data: " + data);
				String[] splitData = data.split(",");

				double newX = Double.parseDouble(splitData[0]);
				double newY = Double.parseDouble(splitData[1]);
				double newZ = Double.parseDouble(splitData[2]);
				int newOrientation = Integer.parseInt(splitData[3]);

				Point newPoint = new Point(newX, newY, newZ, newOrientation);
				//System.out.printf("X: %f, Y: %f, Z: %f, Orientation: %d\n", newX, newY, newZ, newOrientation);
				this.points.add(newPoint);
			}

			fileReader.close();

		} catch (FileNotFoundException error) {
			System.out.println("File Not Found Error.");
			error.printStackTrace();
		}
	}

	private void getDistance(Point inputPoint) {
		for (Point currentPoint : this.points) {
			currentPoint.distance = Math.sqrt(Math.pow((currentPoint.xVal - inputPoint.xVal), 2)
					+ Math.pow((currentPoint.yVal - inputPoint.yVal), 2)
					+ Math.pow((currentPoint.zVal - inputPoint.zVal), 2));
			//System.out.printf("distance: %f\n", currentPoint.distance);
		}
	}

	private class sortPoints implements Comparator<Point> {

		@Override
		public int compare(Point a, Point b) {
			return Double.compare(a.getDistance(),b.getDistance());
		}

	}

	public int predict(Point inputPoint) {

		this.getDistance(inputPoint);
		Collections.sort(this.points, new sortPoints());
		for(Point currentPoint:this.points) {
			//System.out.printf("sortedDistance: %f\n",currentPoint.distance);
		}
		inputPoint.orientation = this.points.get(0).orientation;
		return inputPoint.orientation;
	}
}