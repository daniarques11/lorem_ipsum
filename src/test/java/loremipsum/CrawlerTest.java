package loremipsum;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import loremipsum.Crawler;

/** 
 * Casos test. Todo se testea sobre el array "testNormal", ya que abarca muchos bugs posibles.
 * **/
public class CrawlerTest {

	private static ArrayList<String> testNormal = new ArrayList<String>();
	private static ArrayList<String> testEmpty = new ArrayList<String>();
	private static ArrayList<String> testRequest = new ArrayList<String>();

	// Inicializamos el texto que va a servir para testear
	@BeforeClass
	public static void init() {
		testNormal.add("Hola hola hola hola. Caracola hola. Hooh laal lol lol lol");
		testNormal.add("Hi! Hi? Palindrdnilap hi");
		testNormal.add("     Hi!... Bye wow");
		testNormal.add("wow hola kayak,wow,level. wow! hi hi bye...");
		testNormal.add("     ");
		testNormal.add(".");

		HTTPRequestLoremIpsum req = new HTTPRequestLoremIpsum();
		testRequest = req.paragraphs;

	}

	@Test
	public void paragraphCountTest() {
		Crawler crawler = new Crawler(testNormal);
		assertEquals(crawler.getParagraphCount(), 4);

		Crawler crawlerEmpty = new Crawler(testEmpty);
		assertEquals(crawlerEmpty.getParagraphCount(), 0);

		Crawler crawlerReq = new Crawler(testRequest);
		assertEquals(crawlerReq.getParagraphCount(), 5);
	}

	@Test
	public void phrasesCountTest() {

		Crawler crawler = new Crawler(testNormal);
		assertEquals(crawler.getPhraseCount(), 11);

		Crawler crawlerEmpty = new Crawler(testEmpty);
		assertEquals(crawlerEmpty.getPhraseCount(), 0);

		Crawler crawlerReq = new Crawler(testRequest);
		assertNotEquals(crawlerReq.getPhraseCount(), 0);
	}

	@Test
	public void wordsCountTest() {

		Crawler crawler = new Crawler(testNormal);
		assertEquals(crawler.getWordCount(), 27);

		Crawler crawlerEmpty = new Crawler(testEmpty);
		assertEquals(crawlerEmpty.getWordCount(), 0);

		Crawler crawlerReq = new Crawler(testRequest);
		assertNotEquals(crawlerReq.getWordCount(), 0);
	}

	@Test
	public void isPalindromeTest() {
		Crawler crawler = new Crawler(testNormal);
		assert (crawler.isPalindrome("hooh"));
		assert (crawler.isPalindrome("hoh"));
		assertFalse(crawler.isPalindrome("hola"));
	}

	@Test
	public void palindromeCountTest() {
		Crawler crawler = new Crawler(testNormal);
		assertEquals(crawler.getPalindromeCount(), 12);

		Crawler crawlerEmpty = new Crawler(testEmpty);
		assertEquals(crawlerEmpty.getPalindromeCount(), 0);

	}

	@Test
	public void mostFrequentWordsTest() {
		Crawler crawler = new Crawler(testNormal);
		assert (crawler.getMostFrequentWords().get("hola") == 6);
		assert (crawler.getMostFrequentWords().get("hi") == 6);
		assert (crawler.getMostFrequentWords().get("wow") == 4);
		assert (crawler.getMostFrequentWords().get("lol") == 3);
		assert (crawler.getMostFrequentWords().get("bye") == 2);
		assertFalse(crawler.getMostFrequentWords().containsKey("level"));
		Crawler crawlerEmpty = new Crawler(testEmpty);
		assertEquals(crawlerEmpty.getPalindromeCount(), 0);

		Crawler crawlerReq = new Crawler(testRequest);
		assertNotEquals(crawlerReq.getWordCount(), 0);
	}

	@Test
	public void mostFrequentTuplesTest() {
		Crawler crawler = new Crawler(testNormal);
		assert (crawler.getMostFrequentTuples().get("hola, hola") == 3);
		assert (crawler.getMostFrequentTuples().get("hi, bye") == 2);
		assert (crawler.getMostFrequentTuples().get("hi, hi") == 3);

	}
}
