package driver;

import java.io.File;
import manager.WordTracker;

public class AppDriver {

	/**
	 * main function
	 * @param args input parameters
	 */
	public static void main(String[] args) {
		
		final String options = "-pf,-pl,-po"; 
		
		String inputFileName = "";
		String option = "";
		String outputFileName = "";

		if (args.length != 2 && args.length != 4) {
			System.out.println("Please follow this command: java -jar WordTracker.jar <input.txt> -pf/-pl/-po [-f <output.txt>]");
			return;
		} else {
			inputFileName = args[0];
			option = args[1];
			if (args.length == 4) {
				outputFileName = args[3];
			}
		}

		if (!new File(inputFileName).exists()) {
			System.out.println("The input file does not exist, please re-enter!");
			return;
		}
		
		if (!options.contains(option)) {
			System.out.println("The option parameter is wrong, it must be -pf, -pl, or -po!");
			return;
		}
		
		WordTracker wordTracker = new WordTracker(inputFileName, option, outputFileName);
		wordTracker.Start();
	}
}
