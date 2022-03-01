/**
 * 
 */
package scores;

import java.util.Comparator;

/**
 * Comparator used to compare the points total for a team (Ascending) 
 * @author Charlie McDowell
 *
 */
public class ComparePoints implements Comparator<Team>{

	@Override
	public int compare(Team t1, Team t2) {
		return t2.pointsTotal() - t1.pointsTotal();
	}

}
