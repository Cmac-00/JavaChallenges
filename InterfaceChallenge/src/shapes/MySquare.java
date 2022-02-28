/**
 * 
 */
package shapes;

/**
 * @author Charlie McDowell
 *
 */
public class MySquare implements IMyShape {
	
	private double length;
	private String shapeName;
	
	

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
	public MySquare() {
		
	}
	
	/**
	 * Constructor With args
	 * @param length
	 */
	public MySquare(double length) {
		this.length=length;
		this.shapeName="Square";
	}

	/**
	 * Calculates the perimeter of a square. Called from interface. 
	 */
	@Override
	public double calculatePerimeter() {
		double perimeter = 4 * length;
		return perimeter;
	}

	/**
	 * Calculates the area of a square. Called from interface. 
	 */
	@Override
	public double calculateArea() {
		double area = length * length;
		return area;
	}

	/**
	 * Gets name of shape. 
	 */
	@Override
	public String getShapeName() {
		return shapeName;
	}

}
