/**
 * 
 */
package timeguess;

/**
 * Threaded class that controls the timed element of the game
 * 
 * @author Charlie McDowell
 *
 */
public class Timer implements Runnable {

	// the current time the thread has been running in seconds
	private int currentCount;

	/**
	 * Starts a thread timer - runs to specified length. Will end if the thread is
	 * not interupted.
	 */
	@Override
	public void run() {
		this.currentCount = 0;

		// start a silent timer - will run twice the length of the game
		// time if not interuppted
		try {
			do {
				Thread.sleep(1000);
				currentCount++; // update count every second
			} while (currentCount <= GameControl.gameLength * 2);
		} catch (InterruptedException e) {
			// if interrupted will cause thread to end.
		}

	}

	/**
	 * Returns the current time the thread has been going.
	 * 
	 * @return
	 */
	public int getCurrentCount() {
		return currentCount;
	}

}
