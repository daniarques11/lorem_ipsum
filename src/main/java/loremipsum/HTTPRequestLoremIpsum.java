package loremipsum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Clase encargada de hacer la llamada HTTP a lipsum.com y extraer los párrafos
 **/

public class HTTPRequestLoremIpsum {

	public List<String> paragraphs = new ArrayList<String>();

	public HTTPRequestLoremIpsum() {

		try {
			Document doc = Jsoup.connect("https://es.lipsum.com/feed/html").get();
			Elements elements = doc.select("#lipsum p");

			for (Element element : elements) {
				paragraphs.add(element.text());
			}
			
		} catch (Exception e) {
			System.out.println("No se ha podido conectar con lipsum.com");
		}
	}
}
