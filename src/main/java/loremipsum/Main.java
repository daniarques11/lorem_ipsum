package loremipsum;

public class Main {

	public static void main(String[] args) {
		HTTPRequestLoremIpsum request = new HTTPRequestLoremIpsum();

		if (request.paragraphs.size() != 0) {
			Crawler crawler = new Crawler(request.paragraphs);
			System.out.printf("Frases: %d %nPalabras: %d %nPárrafos: %d %n", crawler.getPhrasesCount(), 0, crawler.getParagraphCount());
			System.out.printf("Palabras palíndromas (%d): %n", 5);
			System.out.println("_palindromos_");
			System.out.printf("Palabras más repetidas (%d): %n", 4);
			System.out.println("__masRepetidas");
			System.out.printf("Tuplas más repetidas (%d): %n", 2);
			System.out.println("__tuplasMasRepetidas");
		}
	}

}
