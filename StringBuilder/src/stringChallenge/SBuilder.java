/**
 * 
 */
package stringChallenge;

/**
 * @author Charlie McDowell
 *
 */
public class SBuilder {

	/**
	 * Test if a string is a palindrome without using the string builder object. 
	 * Use char arrays to reverse a string
	 * @param args
	 */
	public static void main(String[] args) {
		
		String palindrome = "Dot saw I was Tod";
		int length = palindrome.length();
		char[] tempCharArray = new char[length];
		char[] charArray = new char[length];
		
		// put string to array of chars 
			
			for (int loop = 0; loop < palindrome.length(); loop++) {
				tempCharArray[loop] = palindrome.charAt(loop);
			}
			System.out.println(tempCharArray);
			
		// reverse array of chars
			
		for (int loop = 0; loop < palindrome.length(); loop ++) {
			charArray[loop] = tempCharArray [length - 1 - loop];
		}
		
		String reversePalindrome = new String(charArray);
		System.out.println(reversePalindrome);
		
		// check if the original string was a palindrome
		
		if (palindrome.equalsIgnoreCase(reversePalindrome)) {
			System.out.println("Palindrome");
		} else {
			System.out.println("Not a Palindrome");
		}
		
		// Use the string builder object to reverse a string 
		StringBuilder sb = new StringBuilder(palindrome);
		
		sb.reverse();
		
		System.out.println(sb);
		

	}

}
