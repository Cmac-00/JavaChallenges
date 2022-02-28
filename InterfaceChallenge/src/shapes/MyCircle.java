/**
 * 
 */
package shapes;

/**
 * @author Charlie McDowell
 *
 */
public class MyCircle implements IMyShape {
	
	private double radius;
	private String shapeName;
	
	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	/**
	 * Default Constructor 
	 */
	public MyCircle () {
		
	}
	
	/**
	 * Constructor with args.
	 * @param radius
	 */
	public MyCircle(double radius) {
		this.radius=radius;
		this.shapeName="Circle";
	}

	/**
	 * @param shapeName the shapeName to set
	 */
	public void setShapeName(String shapeName) {
		this.shapeName = shapeName;
	}

	// calculate perimeter of the circle. Called from the interface. 
	@Override
	public double calculatePerimeter() {
		double perimeter = 3.14 * 2 * radius;
		return perimeter;
	}

	//Calculates area of a circle. Called from the interface. 
	@Override
	public double calculateArea() {
		double area = 3.14 *(radius * radius);
		return area;
	}
	
	// get the name of the shape. Called from interface. 
	@Override
	public String getShapeName() {
		return shapeName;
	}

	

}
