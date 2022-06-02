import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/** Generates Frequency maps of a large book
 * 
 * @author s-LSILVESTRINI
 *
 */
public class BookMap {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		Scanner book = getBookScanner(console);
		//create map of word occurrences
		Map<String, Integer> bookMap = new TreeMap<String, Integer>();
		
		//open book
		while(book.hasNextLine()) {
			String line = book.nextLine();
			line = formatLine(line);
			Scanner lineScan = new Scanner(line);
			while(lineScan.hasNext()) {
				String token = lineScan.next();
				if(bookMap.containsKey(token)) {
					int value = bookMap.get(token);
					bookMap.put(token,  value + 1);
				} else {
					bookMap.put(token, 1);
				}
			}
			lineScan.close();
		}
		
		//continue prompting user for word until quit
		System.out.println("Enter a word (q to quit)");
		String word = console.nextLine();
		
		while(!word.equals("q")) {
			Integer occurance = bookMap.get(word);
			System.out.println(word + " : " + occurance);
			System.out.println("Enter a word (q to quit)");
			word = console.nextLine();
		}
		
		//share all words in alphabetical order that occur more than 200 times
		for(String key : bookMap.keySet()) {
			Integer occurance = bookMap.get(key);
			if(occurance >= 200) {
				System.out.println(key + " : " + occurance);
			}
		}
		
		console.close();
		book.close();
	}
	
	/** Removes punctuation from a line of text
	 * 
	 * @param s
	 * @return
	 */
	public static String formatLine(String s) {
		s = s.toLowerCase();
		s = s.replace('.', ' ');
		s = s.replace(',', ' ');
		s = s.replace('!', ' ');
		s = s.replace('?', ' ');
		s = s.replace(':', ' ');
		s = s.replace(';', ' ');
		s = s.replace('(', ' ');
		s = s.replace(')', ' ');
		s = s.replace('"', ' ');
		
		return s;
	}
	
	/** Prompts user for text file and returns Scanner
	 * 
	 * @param console
	 * @return
	 * @throws FileNotFoundException
	 */
	public static Scanner getBookScanner(Scanner console) throws FileNotFoundException {
		System.out.println("Give me a book file: ");
		File f = new File(console.nextLine());
		Scanner s = new Scanner(f);
		return s;
	}

}
