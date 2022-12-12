package manager;

import exceptions.TreeException;
import problemdomain.Word;

import java.io.*;
import java.util.*;
import java.util.Iterator;

import referenceBasedTreeImplementation.*;

public class WordTracker {

	private BSTree<Word> wordsTree;
	private String inputFileName = null;
	private String option = null;
	private String outputFileName = null;

	/**
	 * construct function
	 * 
	 * @param inputFile  input filename
	 * @param option     output option
	 * @param outputFile output filename
	 */
	public WordTracker(String inputFile, String option, String outputFile) {
		this.wordsTree = new BSTree<Word>();
		this.inputFileName = inputFile;
		this.option = option;
		this.outputFileName = outputFile;

	}

	/**
	 * Start function
	 */
	public void Start() {
		constructBSTree();
		executeCommand();
	}

	/**
	 * Construct BSTree
	 */
	private void constructBSTree() {
		try {
			File file = new File(inputFileName);
			FileReader fileReader = new FileReader(file);
			Scanner scanner = new Scanner(fileReader);
			int lineNum = 0;
			while (scanner.hasNextLine()) {
				lineNum++;

				String fileLine = scanner.nextLine();
				String[] wordsArray = fileLine.split("[^\\w']+");
				if (wordsArray.length == 0) {
					continue;
				}
				for (String string : wordsArray) {
					if (string != null && !string.equals("")) {
						Word word = new Word(string.toLowerCase(), lineNum, inputFileName);
						try {
							BSTreeNode<Word> foundWords = wordsTree.search(word);
							if (foundWords == null) {
								wordsTree.add(word);
							} else {
								foundWords.getElement().wordCounter(lineNum, inputFileName);
							}
						} catch (Exception e) {
							System.out.println("foundWords is error:" + e.getMessage());
						}
					}
				}
			}
			scanner.close();

			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/repository.ser"));
			for (Iterator<Word> iterator = (Iterator<Word>) wordsTree.inorderIterator(); iterator.hasNext();) {
				Word word = (Word) iterator.next();
				oos.writeObject(word);
			}
			oos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// } catch (TreeException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
		}
	}

	/**
	 * Execute command function
	 */
	private void executeCommand() {
		try {
			PrintWriter out = null;
			if (outputFileName != null && !outputFileName.equals("")) {
				out = new PrintWriter(outputFileName);
			}
			switch (option) {
				case "-pf":
					inOrderPF(wordsTree.getRoot(), out);
					break;
				case "-pl":
					inOrderPL(wordsTree.getRoot(), out);
					break;
				case "-po":
					inOrderPO(wordsTree.getRoot(), out);
					break;
				default:
					System.out.println("Unexpected value: " + option);
			}
			if (out != null) {
				out.flush();
			}
		} catch (TreeException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Print the node value in alphabetical order
	 * 
	 * @param node
	 * @param out
	 */
	public void inOrderPF(BSTreeNode<Word> node, PrintWriter out) {
		if (node == null) {
			return;
		}
		inOrderPF(node.getLeft(), out);
		String result = String.format("Word: %s File Name: %s", node.getElement().getWord(),
				node.getElement().getFileName());
		System.out.println(result);
		if (out != null) {
			out.println(result);
		}
		inOrderPF(node.getRight(), out);
	}

	/**
	 * Print the node value in alphabetical order
	 * 
	 * @param node
	 * @param out
	 */
	public void inOrderPL(BSTreeNode<Word> node, PrintWriter out) {
		if (node == null) {
			return;
		}
		inOrderPL(node.getLeft(), out);
		String result = String.format("Word: %s File Name: %s Line Number: %s",
				node.getElement().getWord(),
				node.getElement().getFileName(),
				node.getElement().getLine());
		System.out.println(result);
		if (out != null) {
			out.println(result);
		}
		inOrderPL(node.getRight(), out);
	}

	/**
	 * Print the node value in alphabetical order
	 * 
	 * @param node
	 * @param out
	 */
	public void inOrderPO(BSTreeNode<Word> node, PrintWriter out) {
		if (node == null) {
			return;
		}
		inOrderPO(node.getLeft(), out);
		String result = node.getElement().toString();
		System.out.println(result);
		if (out != null) {
			out.println(result);
		}
		inOrderPO(node.getRight(), out);
	}

}
