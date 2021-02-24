import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 
 * @author Christopher ID: 1325383 Encodes the data from the linked list to
 *         assign 0 for each unique string of characters and an incrementing
 *         integer for each repeat of that string of characters
 *         
 * Tested on: https://www.gutenberg.org/files/63924/63924-0.txt 
 */

public class MTFEncoder {
	public static void main(String[] args) throws IOException {
		
		//Create a new object for the list of words
		WordList wordlist = new WordList();
		String placeholder = "";

		//Create new files to read data from and send data to
		File filename = new File("./input.txt");
		File outputFile = new File("./encodedFile.txt");
		//Create a new scanner for saving and reading files
		Scanner scanner = new Scanner(filename);
		//Get the next word in the file
		String nextWord = scanner.nextLine();
		//Write to the output file
		PrintWriter writer = new PrintWriter(outputFile);

		try {

			while (nextWord != null) {
				//Break each string into a token
				StringTokenizer token = new StringTokenizer(nextWord);
				//If not at the end of the list of words
				while (token.hasMoreTokens()) {
					//Get the next token and set it to the placeholder variable
					placeholder = token.nextToken();
					
					//If the list of words contains the placeholder variable
					if (wordlist.ContainsElement(placeholder)) {
						//Get the index of the placeholder variable in the list
						int i = wordlist.GetIndex(placeholder);
						//Move that word to the fron of the linked list
						wordlist.MoveToFront(placeholder);
						//Write the word to the output file with a new line character
						//with the updated position of the word
						writer.append(i + "\n");
						writer.flush();

					} else {
						//If the word is not in the list of words
						//add the word to the list
						wordlist.Add(placeholder);
						//And write the new word to the output file with a new line character and the 
						//0th position that it now holds
						writer.append("0 " + placeholder + "\n");
						writer.flush();

					}

				}
				//Read the next word in the file
				nextWord = scanner.nextLine();

			}
			//Close the scanner and the writer objects
			scanner.close();
			writer.close();

		}
		//Catch if at the end of a file
		catch (Exception e) {
			System.out.println("End of file");
		}
	}
}
