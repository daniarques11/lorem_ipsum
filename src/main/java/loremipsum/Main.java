package loremipsum;

public class Main {

	public static void main(String[] args) {
		HTTPRequestLoremIpsum request = new HTTPRequestLoremIpsum();

		if (request.paragraphs.size() != 0) {
			Crawler crawler = new Crawler(request.paragraphs);
			System.out.println("Texto recibido:");
			System.out.print("\n");
			for (String paragraph : crawler.getParagraphs()) {
				System.out.println(paragraph);
			}
			System.out.println("\n");

			System.out.printf("Frases: %d %nPalabras: %d %nPárrafos: %d %n", crawler.getPhraseCount(),
					crawler.getWordCount(), crawler.getParagraphCount());
			System.out.println("\n");

			System.out.printf("Palabras palíndromas (%d): %n", crawler.getPalindromeCount());
			System.out.println(String.join(", ", crawler.getPalindromes()));
			System.out.print("\n");

			System.out.printf("Palabras más repetidas (%d): %n", crawler.getMostFrequentWords().size());
			for (String word : crawler.getMostFrequentWords().keySet()) {
				System.out.println(word + ": " + crawler.getMostFrequentWords().get(word));
			}
			System.out.print("\n");

			System.out.printf("Tuplas más repetidas (%d): %n", crawler.getMostFrequentTuples().size());
			for (String tuple : crawler.getMostFrequentTuples().keySet()) {
				System.out.println(tuple + ": " + crawler.getMostFrequentTuples().get(tuple));
			}
		}
	}

}
