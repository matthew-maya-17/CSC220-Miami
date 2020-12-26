package lab13;

public class WordFisherTester {

	public static void main(String[] args) {
		System.out.println("MOBY-Dick");
		WordFisher MobyDick = new WordFisher("texts/moby-dick.txt", "stopwords.txt");
		System.out.println("Top 10 Words before being pruned: " + MobyDick.getTopWords(10));
		System.out.println("Number of Unique Words: " + MobyDick.getNumUniqueWords());
		System.out.println("Whale Frequency: " + MobyDick.getFrequency("whale"));
		System.out.println("Before pruned: " + MobyDick.getWordCount());
		MobyDick.pruneVocabulary();
		System.out.println("After pruned: " + MobyDick.getWordCount());
		System.out.println("Top 10 Words after being pruned: " + MobyDick.getTopWords(10));
		
		System.out.println("\nALICE");
		WordFisher carrollAlice = new WordFisher("texts/carroll-alice.txt","stopwords.txt");
		System.out.println("Top 10 Words before being pruned: " + carrollAlice.getTopWords(10));
		System.out.println("Number of Unique Words: " + carrollAlice.getNumUniqueWords());
		System.out.println("Whale Frequency: " + carrollAlice.getFrequency("whale"));
		System.out.println("Before pruned: " + carrollAlice.getWordCount());
		carrollAlice.pruneVocabulary();
		System.out.println("After pruned: " + carrollAlice.getWordCount());
		System.out.println("Top 10 Words after being pruned: " + carrollAlice.getTopWords(10));
		System.out.println("Common Popular Words: " + MobyDick.commonPopularWords(20, carrollAlice));
	}

}
