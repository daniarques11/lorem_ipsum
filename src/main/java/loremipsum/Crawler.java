package loremipsum;

import java.util.ArrayList;

public class Crawler {

	private ArrayList<String> paragraphs;

	// Constructor
	public Crawler(ArrayList<String> paragraphs) {
		this.paragraphs = paragraphs;
	}

	void setParagraphs(ArrayList<String> paragraphs) {
		this.paragraphs = paragraphs;
	}

	public int getParagraphCount() {
		int count = 0;
		for (String paragraph : paragraphs) {
			if(!totalTrim(paragraph).isEmpty()) {
				count++;
			}
		}
		return count;
	}

	public int getPhrasesCount() {
		return getPhrasesList().size();
	}

	// Método encargado de hacer split en cada párrafo para obtener una lista de las frases
	public ArrayList<String> getPhrasesList() {
		ArrayList<String> phrasesList = new ArrayList<String>();
		
		for (String paragraph : paragraphs) {
			paragraph = paragraph.replaceAll("[!?]", ".");
			String[] phrases = paragraph.split("\\. |\\.\\.\\. ");
			for (String phrase : phrases) {
				String phraseTrimmed = totalTrim(phrase);
				if (!phraseTrimmed.isEmpty()) {
					phrasesList.add(phraseTrimmed);
				}
			}
		}
		return phrasesList;
	}

	// Se encarga de eliminar espacios en blanco antes y despues de la frase y de eliminar los puntos
	String totalTrim(String str) {
		str = str.trim();
		str = str.replaceAll("[\\.!?]", "");
		return str;
	}
}
