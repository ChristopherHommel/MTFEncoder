import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 
 * @author Christopher
 * ID: 1325383
 * Reads the position and strings of characters in the output file
 * and decodes the encoded file to match what is passed in
 * 
 * Tested on: https://www.gutenberg.org/files/63924/63924-0.txt
 */
public class MTFDecoder {

	public static void main(String[] args) throws IOException {
		
		//Create a new object for the list of words
		WordList wordlist = new WordList();
		String word = "";
		int index;

	
		try {
			
			//Get the names of the input and output files
			File filename = new File("./encodedFile.txt");
			File outputFile = new File("./decodedFile.txt");
			//Create a new scanner and printwriter objects to read and writes to files
			PrintWriter writer = new PrintWriter(outputFile);
			Scanner scanner = new Scanner(filename);

			//Get the next word in the file
			String nextWord = scanner.nextLine();
			//If not at the end of the string of words
			while (nextWord != null) {
				//Set the next word to a new toked
				StringTokenizer token = new StringTokenizer(nextWord);
				//Get the next word
				word = token.nextToken();
				//Reads if there is an integer in the str
				index = Integer.parseInt(word);

				//If the word is the first time occuring 
				//Write it to the output file
				if (index == 0) {
					//Get the next word
					word = token.nextToken();
					//Add the word to the linked list
					wordlist.Add(word);
					//Write the word to the output file
					writer.append(word + " ");
					writer.flush();
				}

				else {
					//Get the word from the linked list based on the ingeter that is passed
					word = wordlist.GetWord(index);
					//Move the word to the front of the list
					wordlist.MoveToFront(word);
					//Write that word to the output file
					writer.append(word + " ");
					writer.flush();
				}
				//Get the next line in the file
				nextWord = scanner.nextLine();
			}
			//Close the scanner and writer
			scanner.close();
			writer.close();
		}
		
		//Catch if at the end of file or if the output file is not found
		catch(FileNotFoundException e) 
		{
			System.out.println("File not found");
		}
		catch (Exception e) {
			System.out.println("End of file");
		}
		
		
	}
}


