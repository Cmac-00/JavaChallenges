/**
 * 
 */
package eightBall;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Charlie McDowell
 *
 */
public class EightBall {

	/**
	 * 
	 * Reads in a users question and outputs a random response.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int randomNumber;
		String question;

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		// prompt user question
		System.out.println("What's your question ? ");
		question = scanner.nextLine();

		// get a random number between 1 - 8
		randomNumber = random.nextInt(8);

		// adding 1 to the randomNumber - why ? well the random.nextInt(8) gives a
		// number between 0 - 7

		System.out.println("You want to know ...");
		System.out.println(question);

		// now give response
		switch (randomNumber) {
		case 1:
			System.out.println("As I see it, yes");
			break;
		case 2:
			System.out.println("Ask again later");
			break;
		case 3:
			System.out.println("Better not tell you now");
			break;
		case 4:
			System.out.println("Cannot predict now");
			break;
		case 5:
			System.out.println("Concentrate and ask again");
			break;
		case 6:
			System.out.println("Don't count on it");
			break;
		case 7:
			System.out.println("It is certain.");
			break;
		case 8:
			System.out.println("It is decidedly so.");
			break;
		default:
			System.out.println("I simply don't know !");
		}
		
		scanner.close();

	}
}
