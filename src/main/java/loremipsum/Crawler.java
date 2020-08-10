package loremipsum;

import java.util.ArrayList;

public class Crawler {

	private ArrayList<String> paragraphs;

	public Crawler(ArrayList<String> paragraphs) {
		this.paragraphs = paragraphs;
	}

	public int getParagraphCount() {
		return paragraphs.size();
	}

	public int getPhrasesCount() {
		return getPhrasesList().size();
	}

	public ArrayList<String> getPhrasesList() {
		ArrayList<String> phrasesList = new ArrayList<String>();
		for (String paragraph : paragraphs) {
			String[] phrases = paragraph.split("\\. ");
			for (String phrase : phrases) {
				phrasesList.add(phrase);
			}
		}
		return phrasesList;
	}
}
