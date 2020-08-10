package loremipsum;

import java.util.ArrayList;

public class Crawler {

	public ArrayList<String> paragraphs;
	public ArrayList<String> phrases;
	public ArrayList<String> words;
	public ArrayList<String> palindromes;



	// Constructor
	public Crawler(ArrayList<String> paragraphs) {
		this.paragraphs = paragraphs;
		this.phrases = getPhrasesList();
		this.words = getWordList();
		this.palindromes = getPalindromeList();
		
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

	public int getPhraseCount() {
		return phrases.size();
	}
	
	public int getWordCount() {
		return words.size();
	}

	public int getPalindromeCount() {
		return palindromes.size();
	}
	// Método encargado de hacer split en cada párrafo para obtener una lista de las frases
	private ArrayList<String> getPhrasesList() {
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

	// Método encargado de hacer split en cada frase para obtener la lista de palabras.
	private ArrayList<String> getWordList(){
		ArrayList<String> wordsList = new ArrayList<String>();
		
		for(String phrase : phrases) {
			String[] words = phrase.split(" ");
			for (String word : words) {
				String wordTrimmed = totalTrim(word);
				if (!wordTrimmed.isEmpty()) {
					wordsList.add(word);
				}
			}
		}
		return wordsList;
		
	}
	
	// Método encargado de recoger las palabras que son palíndromas
	private ArrayList<String> getPalindromeList(){
		ArrayList<String> palindromeList = new ArrayList<String>();
		for (String word : words) {
			if (isPalindrome(word)) {
				palindromeList.add(word);
			}
		}
		return palindromeList;
	}
	
	boolean isPalindrome(String word) {
		int i = 0;
		int j = word.length()-1;
		String lowerCaseWord = word.toLowerCase();
		while (i<j) {
			if(lowerCaseWord.charAt(i) != lowerCaseWord.charAt(j)) {
				return false;
			};
			i++;
			j--;
		}
		return true;
	}
	// Se encarga de eliminar espacios en blanco antes y despues de la frase y de eliminar los puntos
	String totalTrim(String str) {
		str = str.trim();
		str = str.replace(",", " ");
		str = str.replaceAll("[\\.!?,]", "");
		return str;
	}
}
