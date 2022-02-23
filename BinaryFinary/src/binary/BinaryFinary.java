/**
 * 
 */
package binary;

/**
 * @author Charlie McDowell
 *
 */
public class BinaryFinary {

	/**
	 * 
	 * Method that has an array that represents a 8 bit non signed number in an
	 * array of booleans Will cause the array to be printed out as a binary number
	 * and a decimal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// array to represent a binary (NON two complement) number
		boolean[] eightBitArray = { true, false, false, true, false, true, false, true };
		displayArrayAsBinary(eightBitArray);
		System.out.println("\nAs decimal : " + convertToDecimal(eightBitArray));
	}
	
	/**
	 * Displays an array representation of a binary number (booleans for bits) as a
	 * binary (0 or 1 based) number
	 * 
	 * @param binaryArray
	 */
	public static void displayArrayAsBinary(boolean[] binaryArray) {

		// going from left to right in the array to display translated value
		for (int bitPosition = 0; bitPosition < binaryArray.length; bitPosition++) {
			if (binaryArray[bitPosition]) {  // same as binaryArray[bitPosition] == true
				// checking if true - output a 1
				System.out.print("1 ");
			} else {
				// if false outputting a 0
				System.out.print("0 ");
			}
		}
		
	}
		/**
		 * converts a binary number array to its decimal number
		 * 
		 * @param binaryArray
		 * @return
		 */
		public static int convertToDecimal(boolean[] binaryArray) {

			int decimal = 0;

			// need to go from right to left in the binary array index i.e. index 0 if
			// turned ON is true is worth 2 POW of 0. Next element is then 2 POW 1 etc...
			for (int bitPosition = binaryArray.length - 1; bitPosition >= 0; bitPosition--) {
				if (binaryArray[bitPosition]) {
					// get the decimal value for this index
					// so, that is for the first (least significant bit or last index value in the
					// array)
					// Math.pow (2 , 8(length of the array) - 7(array index) and need to offset by 1
					// (-1))
					// so that would be 2 (POW) 0 = 1
					// next index would be 2 (POW) 1 = 2 etc...
					decimal += Math.pow(2, binaryArray.length - bitPosition - 1);
				}
				
			}
			return decimal;
		

	}

}
