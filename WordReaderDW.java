// --== CS400 Project One File Header ==--
// Name: Pranav Mehrotra
// CSL Username: pmehrotra
// Email: pmehrotra3@wisc.edu
// Lecture #: Lecture4 3:30pm-4:20pm [M W F]
// Notes to Grader: <any optional extra notes to your grader>

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class contains the functionality to read a file and return a list of
 * Word objects from it.
 * 
 * @author Pranav Mehrotra
 */
public class WordReaderDW implements WordReaderInterface {

	/**
	 * This method reads the file having the given filename and returns a list of
	 * Word objects from it.
	 * 
	 * @author Pranav Mehrotra
	 * @param filename: A string that stores the name of the file to be read.
	 * @return A List of word objects.
	 */
	@Override
	public List<WordInterface> readWordsFromFile(String filename) throws FileNotFoundException {

		try {

			List<WordInterface> returnable = new ArrayList<WordInterface>(); // List of word objects to be returned.

			Scanner scan = new Scanner(new File(filename + ".csv"));

			while (scan.hasNext()) {

				String[] splitString = scan.nextLine().split(","); // Splitting a line in the file.

				boolean indicator = false;

				// If the word of a given type already exists then adding its new descriptition
				// to the ArrayList.

				for (int i = 0; i < returnable.size(); i++) {

					if (returnable.get(i).getWord().equals(splitString[0])) {

						returnable.get(i).getDescription().add(splitString[2]);

						returnable.get(i).getType().add(splitString[1]);

						indicator = true;
					}
				}

				// If the word does not already exist, creating a new word and adding it to the
				// list of words.

				if (!(indicator)) {

					ArrayList<String> arrayList1 = new ArrayList<String>();

					ArrayList<String> arrayList2 = new ArrayList<String>();

					arrayList1.add(splitString[2]);

					arrayList2.add(splitString[1]);

					WordDW newObject = new WordDW(splitString[0], arrayList2, arrayList1);

					returnable.add(newObject);
				}
			}

			scan.close();

			return returnable;

		}

		catch (FileNotFoundException a) {

			throw new FileNotFoundException("ERROR: File with given filename does not exist.");

		}
	}

}
