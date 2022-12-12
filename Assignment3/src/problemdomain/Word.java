package problemdomain;

import java.io.Serializable;
import java.util.ArrayList;

public class Word implements Comparable<Word>, Serializable{
	
	/**
	 * 
	 */
	private String word;
	private ArrayList<Integer> line = new ArrayList<>();
	private ArrayList<String> fileName = new ArrayList<>();
	private int occurrence = 0;
	
	
	
	/**
	 * @param word
	 * @param line
	 * @param fileName
	 */
	public Word(String word, int line, String fileName) {
		super();
		this.word = word;
		this.line.add(line);
		this.fileName.add(fileName);
		occurrence++;
	}
	
	
	/** 
	 * @param wordLine
	 * @param wordFileName
	 */
	public void wordCounter(int wordLine, String wordFileName) {


		if (fileName.contains(wordFileName)) {
			if (line.contains(wordLine)) {
				occurrence++;
				return;
			} 
			this.line.add(wordLine);
			occurrence++;
		} else {
			this.fileName.add(wordFileName);
			this.line.add(wordLine);
			occurrence++;
		}



	}


	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}


	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}


	/**
	 * @return the line
	 */
	public ArrayList<Integer> getLine() {
		return line;
	}


	/**
	 * @param line the line to set
	 */
	public void setLine(ArrayList<Integer> line) {
		this.line = line;
	}



	/**
	 * @return the fileName
	 */
	public ArrayList<String> getFileName() {
		return fileName;
	}


	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(ArrayList<String> fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * @return the occurence
	 */
	public int getOccurence() {
		return occurrence;
	}

	/**
	 * @param occurence the occurence to set
	 */
	public void setOccurence(int occurence) {
		this.occurrence = occurence;
	}

	
	/** 
	 * @param word
	 * @return int
	 */
	@Override
	public int compareTo(Word word) {
		// TODO Auto-generated method stub
		return this.word.compareTo(word.getWord());
	}
	
	
	/** 
	 * @return String
	 */
	@Override
	public String toString() {
		return String.format("Word: %s File Name: %s Line Number: %s Occurrence: %d", 
				word, fileName, getLine(), occurrence);
	}
}
