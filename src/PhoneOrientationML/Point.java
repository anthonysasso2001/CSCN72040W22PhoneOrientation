package PhoneOrientationML;

public class Point {
	
	/**
	 * Values for a 3d point
	 */
	int xVal;
	int yVal;
	int zVal;
	
	/**
	 * default constructor zero values data
	 */
	public Point() {
		this.xVal = 0;
		this.yVal = 0;
		this.zVal = 0;
	}
	
	/**
	 * Parameterized constructor sets each (with 0 for ignored values
	 * @param xVal - input value for X plane
	 * @param yVal - input value for Y plane
	 * @param zVal - input value for Z plane
	 */
	public Point(int xVal, int yVal, int zVal) {
		this.xVal = xVal;
		this.yVal = yVal;
		this.zVal = zVal;
	}
	
	/**
	 * Get X plane for point
	 * @return value for X plane
	 */
	public int getxVal() {
		return xVal;
	}
	
	/**
	 * Set X plane for point
	 * @param xVal - new X value for point
	 */
	public void setxVal(int xVal) {
		this.xVal = xVal;
	}
	
	/**
	 * Get Y plane for point
	 * @return value for Y plane
	 */
	public int getyVal() {
		return yVal;
	}
	
	/**
	 * Set Y plane for point
	 * @param yVal - new Y value for point
	 */
	public void setyVal(int yVal) {
		this.yVal = yVal;
	}
	
	/**
	 * Get Y plane for point
	 * @return value for Y plane
	 */
	public int getzVal() {
		return zVal;
	}
	
	/**
	 * Set Z plane for point
	 * @param zVal - new Z value for point
	 */
	public void setzVal(int zVal) {
		this.zVal = zVal;
	}
}
