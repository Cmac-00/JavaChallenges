/**
 * 
 */
package shapes;

import java.util.Random;

/**
 * 
 * Class with a main method.
 * @author Charlie McDowell
 *
 */
public class MyController {
	
	private static final int NUMBER_OF_SHAPES = 10;

	/**
	 * Testing how the shape classes and interface runs on the main method.
	 * @param args
	 */
	public static void main(String[] args) {
		
		IMyShape myShapes[] = new IMyShape[NUMBER_OF_SHAPES];
		
		// create shapes
		generateShapes(myShapes);
		
		// display the names, areas and perimeters of shapes in array
		// use of programming to an interface
		displayShapeInfo(myShapes);
		

	}
	
	/**
	 * Generates Random shapes and adds to the array of IMyShapes
	 * @param shapes
	 */
	private static void generateShapes(IMyShape[] shapes) {
		// create random number generator
		Random generator = new Random();
		
		//randomly create the shapes and store in the array
		for (int loop=0; loop < shapes.length; loop++) {
			// swicth on a number between 0-2 inclusive 
			switch (generator.nextInt(3)) {
			case 0:
				shapes[loop] = new MyCircle(generator.nextDouble() * (generator.nextInt(10) +1));
				break;
			case 1: 
				shapes[loop] = new MySquare(generator.nextDouble() * (generator.nextInt(10) + 1));
				break;
			case 2:
				shapes[loop] = new MyRectangle(generator.nextDouble() * (generator.nextInt(10) + 1),
						generator.nextDouble() * (generator.nextInt(10) + 1));

			}
		}
	
	
	}
	
	/**
	 * displays all shapes
	 * 
	 * @param shapes
	 */
	private static void displayShapeInfo(IMyShape[] shapes) {
		System.out.println();
		for (IMyShape shape : shapes) {
			System.out.print(shape.getShapeName());
			System.out.printf(" Area: %.2f", shape.calculateArea());
			System.out.printf(" Perimeter: %.2f", shape.calculatePerimeter());

			if (shape instanceof MySquare) {
				MySquare square = (MySquare) shape;
				System.out.printf(" Square length %.2f", square.getLength());
			} else if (shape instanceof MyRectangle) {
				MyRectangle rectangle = (MyRectangle) shape;
				System.out.printf(" Rectangle breadth %.2f", rectangle.getBreadth());
			} else if (shape instanceof MyCircle) {
				MyCircle circle = (MyCircle) shape;
				System.out.printf(" Circle radius %.2f", circle.getRadius());
			} else {
				// nothing else to do.. shape not recognised
			}
			System.out.println();

		}
	}

}
