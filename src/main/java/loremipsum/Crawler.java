package loremipsum;

import java.util.ArrayList;

public class Crawler {

	private ArrayList paragraphs;
	
	public Crawler(ArrayList paragraphs){
		this.paragraphs = paragraphs;
	}
	
	public int getParagraphCount() {
		return paragraphs.size();
	}
}
