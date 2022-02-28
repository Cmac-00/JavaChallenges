/**
 * 
 */
package shapes;

/**
 * @author Charlie McDowell
 *
 */
public class MyRectangle implements IMyShape {
	
	private double breadth; 
	private double length; 
	private String shapeName;
	
	

	/**
	 * @return the breadth
	 */
	public double getBreadth() {
		return breadth;
	}

	/**
	 * @param breadth the breadth to set
	 */
	public void setBreadth(double breadth) {
		this.breadth = breadth;
	}

	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(double length) {
		this.length = length;
	}

	/**
	 * @param shapeName the shapeName to set
	 */
	public void setShapeName(String shapeName) {
		this.shapeName = shapeName;
	}
	
	/**
	 * Default Constructor 
	 */
	public MyRectangle() {
		
	}
	
	/**
	 * Constructor with args 
	 * @param breadth
	 * @param length
	 */
	public MyRectangle (double breadth, double length) {
		this.breadth=breadth;
		this.length=length;
		this.shapeName="Rectangle";
	}

	/**
	 * Calculates perimeter of Rectangle.
	 */
	@Override
	public double calculatePerimeter() {
		double perimeter = 2 * (breadth+length);
		return perimeter;
	}

	/**
	 * Calculates the area of the Rectangle 
	 */
	@Override
	public double calculateArea() {
		double area = length * breadth;
		return area;
	}

	/**
	 * Gets the name of the shape
	 */
	@Override
	public String getShapeName() {
		return shapeName;
	}

}
