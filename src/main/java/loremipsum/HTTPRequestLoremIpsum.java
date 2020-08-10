package loremipsum;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Clase encargada de hacer la llamada HTTP a lipsum.com y extraer los párrafos.
 * Cuando se instancia la clase, instantáneamente se hace la llamada.
 **/

public class HTTPRequestLoremIpsum {

	public ArrayList<String> paragraphs = new ArrayList<String>();

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
