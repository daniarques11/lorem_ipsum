package loremipsum;

import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HTTPRequestLoremIpsum {

	public static void main(String[] args) throws IOException {

		Document doc = Jsoup.connect("https://es.lipsum.com/feed/html").get();
		Elements elements = doc.select("#lipsum p");

		System.out.println(elements);
	}
}
