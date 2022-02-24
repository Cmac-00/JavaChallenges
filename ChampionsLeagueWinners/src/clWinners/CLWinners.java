/**
 * 
 */
package clWinners;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * @author Charlie McDowell
 *
 */
public class CLWinners {

	/**
	 * main method that coordinates the redaing of a file of winner by year of the
	 * European Cup. Outputs that by year to screen then output the teams that have won (ie no duplicates)
	 * @param args
	 */
	public static void main(String[] args) {
		// get the list of each winning team by year (will contain duplicates)
				ArrayList<String> allWinners = readAndPopulateWinnersList();

				if (allWinners.size() == 0) {
					// no teams returned
					System.out.println("No winners ! Maybe check the list of winners");
				} else {
					System.out.println("List of winners by year...");
					int startYear = 1956;
					for (String team : allWinners) {
						System.out.println(startYear++ + " : " + team);
					}

					// roll of honour - list of winners (no duplicates)
					ArrayList<String> winningClubs = new ArrayList<String>();
					for (int loop = 0; loop < allWinners.size(); loop++) {
						// check if we need to add this one - i.e. first time winner
						if (!winningClubs.contains(allWinners.get(loop))) {
							winningClubs.add(allWinners.get(loop));
						}
					}
					// show clubs that have won the competition (no duplicates)
					System.out.println(winningClubs.toString());

				}

			}

			/**
			 * Read in the list from file
			 * 
			 * @return
			 */
			public static ArrayList<String> readAndPopulateWinnersList() {

				ArrayList<String> listOfWinners = new ArrayList<String>();

				try {
					// access and read the file
					File file = new File("ECWinners.txt");

					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);

					// read the first line (team)
					String team = br.readLine();

					// add to (and continue to add team to arraylist
					while (team != null) {
						listOfWinners.add(team);
						team = br.readLine();
					}

					// here now all reading is done

					br.close();
					fr.close();

				} catch (FileNotFoundException e) {
					System.out.println("Cannot find file !");
				} catch (Exception exception) {
					System.out.println("Other problem");
				}

				// return the list
				return listOfWinners;

			}

		
		

	}


