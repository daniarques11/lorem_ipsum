package loremipsum;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import loremipsum.Crawler;

public class CrawlerTest {

	private static ArrayList<String> testNormal = new ArrayList<String>();
	private static ArrayList<String> testEmpty = new ArrayList<String>();

	@BeforeClass
	public static void init() {
		testNormal.add("Hola. Caracola hola. Hooh laal lol");
		testNormal.add("Hi! Palindrdnilap");
		testNormal.add("     Hi!... Bye");
		testNormal.add("kayak,wow,level. wow! bye...");
		testNormal.add("     ");
		testNormal.add(".");


	}

	@Test
	public void phrasesCountTest() {

		Crawler crawler = new Crawler(testNormal);
		assertEquals(crawler.getPhrasesCount(), 10);
		
		crawler.setParagraphs(testEmpty);
		assertEquals(crawler.getPhrasesCount(), 0);
	}
}
