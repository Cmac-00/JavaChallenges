/**
 * 
 */
package scores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Class reads in a txt file with a list of scores. Processes the results and
 * updates the team stats and league table.
 * 
 * @author Charlie McDowell
 *
 */
public class ScoreManager {
	/**
	 * Stores the results from file for processing
	 */
	private static ArrayList<String> results = new ArrayList<String>();

	/**
	 * Map to store the team names (key) and the team stats (values)
	 */
	private static Map<String, Team> teams = new HashMap<String, Team>();

	private final static int WIN_POINTS = 3;
	private final static int DRAW_POINTS = 1;
	private final static int LOSS_POINTS = 0;

	/**
	 * Start point for the app
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// read scores from the file
		readScoresFile();
		
		// process the results
		processResults();
		
		//output to screen team stats
		showAllTeamsStats();
		
		//show league table
		showLeague();

	}

	/**
	 * Reads the scores line by line and stores in arraylist
	 */
	public static void readScoresFile() {
		try {
			File file = new File("Results.txt");

			FileReader fr;
			BufferedReader br;

			fr = new FileReader(file);
			br = new BufferedReader(fr);

			String result = br.readLine();
			while (result != null) {
				results.add(result);
				result = br.readLine();
			}

			System.out.println(results.toString());

			br.close();
			fr.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException E) {
			E.printStackTrace();
		}
	}

	/**
	 * Process results line by line
	 */
	private static void processResults() {
		String[] gameStats;
		String team1, team2;
		int team1Score, team2Score, team1Points, team2Points;

		// read each score
		for (String result : results) {

			// split the string
			gameStats = result.split(" "); // split based on space

			// results in a string array format
			// [0] [1] [2] [3]
			// team1 team1score team2 team2score
			team1 = gameStats[0];
			team1Score = Integer.parseInt(gameStats[1]);
			team2Score = Integer.parseInt(gameStats[2]);
			team2 = gameStats[3];

			if (team1Score > team2Score) {
				team1Points = WIN_POINTS;
				team2Points = LOSS_POINTS;
			} else if (team1Score < team2Score) {
				team1Points = LOSS_POINTS;
				team2Points = WIN_POINTS;
			} else {
				team1Points = DRAW_POINTS;
				team2Points = DRAW_POINTS;
			}
			// update the team stats for both teams
			updateTeamStats(team1, team1Score, team2Score, team1Points);
			updateTeamStats(team2, team2Score, team1Score, team2Points);
		}
	}

	public static void updateTeamStats(String team, int goalsScored, int goalsConceeded, int teamPoints) {
		// check if the team HashMap has the team in the key
		if (teams.containsKey(team)) {
			// already in the HashMap key - so get the current details and
			// update
			Team teamDetails = teams.get(team);
			teamDetails.incrementGamesPlayed();
			teamDetails.increaseGoalsFor(goalsScored);
			teamDetails.increaseGoalsAgainst(goalsConceeded);

			// calculate win, loss, draw stats
			switch (teamPoints) {
			case WIN_POINTS:
				teamDetails.incrementWins();
				break;
			case DRAW_POINTS:
				teamDetails.incrementDraws();
				break;
			case LOSS_POINTS:
				teamDetails.incrementLosses();
				break;
			default:
				break;
			}

		} else {
			// first time read for this team. Need to add the key and value
			teams.put(team, new Team(team));
			// recursive call
			updateTeamStats(team, goalsScored, goalsConceeded, teamPoints);
		}

	}

	/**
	 * Shows each team stats to screen
	 */
	public static void showAllTeamsStats() {
		// sort by keys (alphabetically) - switching to a TreeMap
		SortedMap<String, Team> sortedTeams = new TreeMap<>(teams);
		// show all
		for (String team : sortedTeams.keySet()) {
			System.out.println(team);
			Team t = teams.get(team);
			System.out.println(t.stats() + "\n");
		}
	}

	/**
	 * Shows the league details in the format... Team Played For Against W D L
	 * Points Arsenal 3 17 4 3 0 0 9
	 */
	public static void showLeague() {
		// Going to need to order by points so first get the values in the
		// HashMap and put into a List
		List<Team> allTeams = new ArrayList<Team>(teams.values());

		// now sort using comparator
		Collections.sort(allTeams, new ComparePoints());

		// output to screen (lots of formatting here - don't spend too much time on
		// formatting getting the data out is the main thing
		// although if really keen https://www.baeldung.com/java-printstream-printf !)
		System.out.printf("%-20s %-6s %-5s %-10s %-2s %-2s %-8s %-6s\n", "Team", "Played", "For", "Against", "W", "D",
				"L", "Points");
		for (Team t : allTeams) {
			System.out.printf("%-20s %-6d %-5d %-10d %-2d %-2d %-8d %-6d\n", t.getName(), t.getGamesPlayed(),
					t.getGoalsFor(), t.getGoalsAgainst(), t.getWins(), t.getDraws(), t.getLosses(), t.pointsTotal());
		}
	}

}
