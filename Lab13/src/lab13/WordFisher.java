package lab13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Comparator;

public class WordFisher {
	public HashMap<String, Integer> vocabulary;
	private List<String> stopwords;
	private String inputTextFile;
	private String stopwordsFile;
	
	public WordFisher(String inputTextFile, String stopwordsFile) {
		this.inputTextFile = inputTextFile;
		this.stopwordsFile = stopwordsFile;
		getStopwords();
		buildVocabulary();
	}
	private static class WordNode {
		public String word;
		public int frequency;
		public WordNode(String word, int frequency) {
			this.word = word;
			this.frequency = frequency;
		}
	}
	protected class FrequencyComparator implements Comparator<WordNode> {
		public int compare(WordNode word1, WordNode word2) {
			  if(word1.frequency < word2.frequency) {
				  return 1;
			  }
			  else if(word1.frequency > word2.frequency) {
				  return -1; 
			  }
			  else {
				  return 0;
			  }
		}
	}
	private void getStopwords() {
		try {
			stopwords = new ArrayList <String>();
			BufferedReader input = new BufferedReader(new FileReader(stopwordsFile));
			// FILL IN
			String line = input.readLine();
			while(line != null) {
				stopwords.add(line);
				line = input.readLine();
			}
			input.close();
		}
		catch (IOException e) {
			e.printStackTrace();
			System.err.println("IO Exception: getStopwords\n");
		}
	}
	private void buildVocabulary() {
		vocabulary = new HashMap<String, Integer>();
		String reader = "";
		try {
			reader = new String(Files.readAllBytes(Paths.get(inputTextFile)));
		}
		catch(IOException e) {
			e.printStackTrace();
			System.err.println("IO Exception: buildVocabulary\n");
		}
		reader = reader.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "");
		String[] allWords = reader.split("\\s+"); // any # of spaces 
		for(int i = 0; i < allWords.length; i++) {
			if(vocabulary.containsKey(allWords[i])) {
				int frequency = vocabulary.get(allWords[i]);
				vocabulary.replace(allWords[i], frequency + 1);
			}
			else {
				vocabulary.put(allWords[i], 1);
			}
		}
	}
	public int getWordCount() {
		int wordCount = 0;
		for (String word: vocabulary.keySet()) {
			wordCount += vocabulary.get(word);
		}
		return wordCount;
	}
	public int getNumUniqueWords() {
		return vocabulary.size();
	}
	public int getFrequency(String word) {
		if (vocabulary.containsKey(word)) {
			return vocabulary.get(word);
		} 
		else {
			return -1;
		}
	}
	public void pruneVocabulary() {
		for (int i = 0; i < stopwords.size(); i++) {
			vocabulary.remove(stopwords.get(i));
		}
	}
	public ArrayList<String> getTopWords(int n) {
		PriorityQueue<WordNode> topWords = new PriorityQueue<WordNode>(new FrequencyComparator());
		for(String key: vocabulary.keySet()) {
			WordNode newWords = new WordNode(key, vocabulary.get(key));
			topWords.add(newWords);
		}
		ArrayList<String> topWords2 = new ArrayList<String>();
		for(int j = 0; j < n; j++) {
			topWords2.add(topWords.poll().word);
		}
		return topWords2;
	}
	public ArrayList<String> commonPopularWords(int n, WordFisher other){
		ArrayList<String> topWords1 = this.getTopWords(n);
		ArrayList<String> topWords2 = other.getTopWords(n);
		ArrayList<String> commonWords = new ArrayList<String>();
		for(int w = 0; w < n; w++) {
			if(topWords1.contains(topWords2.get(w))) {
				commonWords.add(topWords2.get(w));
			}
		}
		return commonWords;
	}
	
}
