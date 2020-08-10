package loremipsum;

import static org.junit.Assert.assertEquals;

import java.net.http.HttpRequest;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import loremipsum.Crawler;

public class CrawlerTest {

	private static ArrayList<String> testNormal = new ArrayList<String>();
	private static ArrayList<String> testEmpty = new ArrayList<String>();
	private static ArrayList<String> testRequest = new ArrayList<String>();

	// Inicializamos el texto que va a servir para testear
	@BeforeClass
	public static void init() {
		testNormal.add("Hola. Caracola hola. Hooh laal lol");
		testNormal.add("Hi! Palindrdnilap");
		testNormal.add("     Hi!... Bye");
		testNormal.add("kayak,wow,level. wow! bye...");
		testNormal.add("     ");
		testNormal.add(".");
		
		HTTPRequestLoremIpsum req = new HTTPRequestLoremIpsum();
		testRequest = req.paragraphs;


	}

	@Test
	public void paragraphCountTest() {
		Crawler crawler = new Crawler(testNormal);
		assertEquals(crawler.getParagraphCount(), 4);
		
		crawler.setParagraphs(testEmpty);
		assertEquals(crawler.getParagraphCount(), 0);
		
		crawler.setParagraphs(testRequest);
		assertEquals(crawler.getParagraphCount(), 5);
	}
	@Test
	public void phrasesCountTest() {

		Crawler crawler = new Crawler(testNormal);
		assertEquals(crawler.getPhrasesCount(), 10);
		
		crawler.setParagraphs(testEmpty);
		assertEquals(crawler.getPhrasesCount(), 0);
	}
}
