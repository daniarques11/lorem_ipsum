package loremipsum;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HTTPRequestLoremIpsum {

	private static final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1)
			.connectTimeout(Duration.ofSeconds(10)).build();

	public static void main(String[] args) throws IOException, InterruptedException {

		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create("https://es.lipsum.com/feed/html"))
				.setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
				.build();

		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());


		System.out.println(response.body());
	}
}
