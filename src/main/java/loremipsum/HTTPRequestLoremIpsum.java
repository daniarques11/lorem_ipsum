package loremipsum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/** Clase encargada de hacer la llamada HTTP a lipsum.com y extraer los párrafos **/

public class HTTPRequestLoremIpsum {
	
	public static List<String> paragraphs = new ArrayList<String>();

	public static void main(String[] args) throws IOException {

		Document doc = Jsoup.connect("https://es.lipsum.com/feed/html").get();
		Elements elements = doc.select("#lipsum p");

		for (Element element : elements) {
			paragraphs.add(element.text());
			System.out.println(element.text());
		}
		System.out.println(paragraphs);
	}
}
