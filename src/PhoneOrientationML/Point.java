package PhoneOrientationML;

public class Point {

	/**
	 * Values for a 3d point, plus orientation and distance for predicted / known
	 */
	double xVal;
	double yVal;
	double zVal;
	int orientation;
	double distance;

	/**
	 * default constructor zero values data
	 */
	public Point() {
		this.xVal = 0;
		this.yVal = 0;
		this.zVal = 0;
		this.orientation = 0;
		this.distance = 0;
	}

	/**
	 * Parameterized constructor for unknown
	 * 
	 * @param xVal - input value for X plane
	 * @param yVal - input value for Y plane
	 * @param zVal - input value for Z plane
	 */
	public Point(double xVal, double yVal, double zVal) {
		this.xVal = xVal;
		this.yVal = yVal;
		this.zVal = zVal;
		this.orientation = 0;
		this.distance = 0;
	}

	/**
	 * Parameterized constructor for known
	 * 
	 * @param xVal - input value for X plane
	 * @param yVal - input value for Y plane
	 * @param zVal - input value for Z plane
	 */
	public Point(double xVal, double yVal, double zVal, int orientation) {
		this.xVal = xVal;
		this.yVal = yVal;
		this.zVal = zVal;
		this.orientation = orientation;
		this.distance = 0;
	}

	/**
	 * Get X plane for point
	 * 
	 * @return value for X plane
	 */
	public double getxVal() {
		return xVal;
	}

	/**
	 * Set X plane for point
	 * 
	 * @param xVal - new X value for point
	 */
	public void setxVal(double xVal) {
		this.xVal = xVal;
	}

	/**
	 * Get Y plane for point
	 * 
	 * @return value for Y plane
	 */
	public double getyVal() {
		return yVal;
	}

	/**
	 * Set Y plane for point
	 * 
	 * @param yVal - new Y value for point
	 */
	public void setyVal(double yVal) {
		this.yVal = yVal;
	}

	/**
	 * Get Y plane for point
	 * 
	 * @return value for Y plane
	 */
	public double getzVal() {
		return zVal;
	}

	/**
	 * Set Z plane for point
	 * 
	 * @param zVal - new Z value for point
	 */
	public void setzVal(double zVal) {
		this.zVal = zVal;
	}

	/**
	 * get known orientation for point
	 * 
	 * @return integer representation for orientation
	 */
	public int getOrientation() {
		return orientation;
	}

	/**
	 * set known orientation for point
	 * 
	 * @param orientation - input new orientation for point
	 */
	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}

	/**
	 * get known relative distance for point
	 * 
	 * @return double representation for distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * set known distance for point
	 * 
	 * @param distance - input new relative distance for point
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}
}