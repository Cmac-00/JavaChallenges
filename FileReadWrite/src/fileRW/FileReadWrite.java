/**
 * 
 */
package fileRW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Charlie McDowell
 *
 */
public class FileReadWrite {

	/**
	 * Main method to read in file Catch 22 and count number of words, lines etc.. 
	 * Also writes the new redacted version of the file
	 * @param args
	 */
	public static void main(String[] args) {
		
		File file = new File("Catch 22.txt");
		File redeacted = new File("Catch22Redacted.txt");
		
		String line;
		int numberOfLines, numberOfWords, numberOfChars, yossarian, catch22, aCount;
		
		// challenges 
		// output the text to screen
		// number of lines of text
		// how many times is the main character "Yossarian" referenced
		// how many times is "Catch 22" mentioned
		// number of 'a's
		// redact a specified word ...i.e. Yossarian
		
		numberOfLines=0;
		numberOfWords=0;
		numberOfChars=0;
		yossarian=0;
		catch22=0;
		aCount=0;
		
		try {
			// getting file to read
			FileReader fileReader = new FileReader(file.getName());
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			// organising file to write to..
			FileWriter fileWriter = new FileWriter(redeacted.getName());
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			line = bufferedReader.readLine();
			
			while (line != null) {
				System.out.println(line);
				numberOfChars+=line.length();
				numberOfLines++;
				
				// number of words in the line - need to tokenise
				String[] words = line.split(" ");
				numberOfWords+=words.length;
				
				// finding instances of Catch 22
				if(line.contains("Catch 22")) {
					catch22++;
				}
				
				// finding instances of "Yossarian"
				if (line.contains("Yossarian")) {
					yossarian++;
					
					// String redact with ---------
					
					String redactedLine = line.replace("Yossarian", "---------");
					bufferedWriter.write(redactedLine +"\n");
					
				} else {
					bufferedWriter.write(line+"\n");
				}
				
				
				
				// how many a's
				for (int loop=0;loop<line.length();loop++) {
					
					
					switch (line.charAt(loop)) {
					case 'a':
					case 'A': 
						aCount++;
						break;
					default :
						
					}
					
						
				}
				line = bufferedReader.readLine();
			}
		
			bufferedReader.close();
			fileReader.close();
			
			bufferedWriter.close();
			fileWriter.close();
			
			// output stats
			System.out.println("Number of lines     : "+numberOfLines);
			System.out.println("Numer of words      : "+numberOfWords);
			System.out.println("Number of chars     : "+numberOfChars);
			System.out.println("Number of yossarian : "+yossarian);
			System.out.println("Number of Catch 22  : "+catch22);
			System.out.println("Number of a's       : "+aCount);
			
			
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Can't find the book !");
		} catch (IOException e) {
			
			System.out.println("Oops ... Input outpuit issue!");
		}
		

	}

}
