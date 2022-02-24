/**
 * 
 */
package quiz;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Charlie McDowell
 *
 */
public class Quiz {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// scanner to get user input
				Scanner scanner = new Scanner(System.in);

				try {
					// declaring the questions and answers 
					String[] sampleQuestions = { "Largest planet ? ", "Fastest Animal ? ", "Capital of Peru?",
							"Roman god of War ?" };
					String[] sampleAnswers = { "Jupiter", "Cheetah", "Lima", "Mars" };

					// vars for the game
					Random random = new Random();
					String userAnswer;
					String anotherQuestion;

					System.out.println("General Knowledge quiz....");

					// wrapping the game in a loop
					do {

						// gets a random index value so the user gets a random question each time
						int questionIndex;
						questionIndex = random.nextInt(sampleQuestions.length);

						System.out.println(sampleQuestions[questionIndex]);

						System.out.println("Your answer ...");
						userAnswer = scanner.nextLine();
						// checking the user answer against the expected answer
						if (userAnswer.equalsIgnoreCase(sampleAnswers[questionIndex])) {
							System.out.println("Well done !");
						} else {
							System.out.println("Not a bad guess but it was " + sampleAnswers[questionIndex]);
						}

						System.out.println("Another question (Y or N)..");
						anotherQuestion = scanner.nextLine();

					} while (anotherQuestion.equalsIgnoreCase("Y"));

				} catch (Exception exception) {
					System.out.println("The quiz master had a problem ... run the game again.");
				} finally {
					scanner.close();
					System.out.println("Thanks for playing");
				}

	}

}
