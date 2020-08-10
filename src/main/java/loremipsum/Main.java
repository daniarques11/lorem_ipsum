package loremipsum;

public class Main {

	public static void main(String[] args) {
		HTTPRequestLoremIpsum request = new HTTPRequestLoremIpsum();

		if (request.paragraphs.size() != 0) {
			Crawler crawler = new Crawler(request.paragraphs);
			System.out.println(request.paragraphs);
			System.out.printf("Frases: %d %nPalabras: %d %nPárrafos: %d %n", crawler.getPhraseCount(), crawler.getWordCount(), crawler.getParagraphCount());
			System.out.printf("Palabras palíndromas (%d): %n", crawler.getPalindromeCount());
			System.out.println(crawler.getPalindromeList());
			System.out.printf("Palabras más repetidas (%d): %n", 4);
			System.out.println("__masRepetidas");
			System.out.printf("Tuplas más repetidas (%d): %n", 2);
			System.out.println("__tuplasMasRepetidas");
		}
	}

}
