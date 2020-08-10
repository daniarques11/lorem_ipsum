package loremipsum;

import java.util.ArrayList;
import java.util.HashMap;

public class Crawler {

	public ArrayList<String> paragraphs;
	public ArrayList<String> phrases;
	public ArrayList<String> words;
	public ArrayList<String> palindromes;
	public HashMap<String, Integer> wordFreqMap;

	// Constructor
	public Crawler(ArrayList<String> paragraphs) {
		this.paragraphs = paragraphs;
		this.phrases = getPhrasesList();
		this.words = getWordList();
		this.palindromes = getPalindromeList();
		this.wordFreqMap = getWordFrequency();

	}

	public int getParagraphCount() {
		int count = 0;
		for (String paragraph : paragraphs) {
			if (!totalTrim(paragraph).isEmpty()) {
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
	
	public HashMap<String, Integer> getMostFrequentWords(){
		return mostFrequentWords();
	}

	// Método encargado de hacer split en cada párrafo para obtener una lista de las
	// frases
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

	// Método encargado de hacer split en cada frase para obtener la lista de
	// palabras.
	private ArrayList<String> getWordList() {
		ArrayList<String> wordsList = new ArrayList<String>();

		for (String phrase : phrases) {
			String[] words = phrase.split(" ");
			for (String word : words) {
				String wordTrimmed = totalTrim(word);
				if (!wordTrimmed.isEmpty()) {
					wordsList.add(word.toLowerCase());
				}
			}
		}
		return wordsList;

	}

	// Método encargado de recoger las palabras que son palíndromas
	private ArrayList<String> getPalindromeList() {
		ArrayList<String> palindromeList = new ArrayList<String>();
		for (String word : words) {
			if (isPalindrome(word)) {
				palindromeList.add(word);
			}
		}
		return palindromeList;
	}

	// Método encargado de almacenar en un mapa la frecuencia de cada palabra
	private HashMap<String, Integer> getWordFrequency() {
		HashMap<String, Integer> wordFreqMap = new HashMap<String, Integer>();
		for (String word : words) {
			wordFreqMap.compute(word, (key, value) -> (value == null) ? 1 : value + 1);
		}
		return wordFreqMap;
	}

	// Encuentra las 5 primeras palabras mas freqüentes
	private HashMap<String, Integer> mostFrequentWords() {
		HashMap<String, Integer> mostFreqMap = new HashMap<String, Integer>();
		HashMap<String, Integer> mapCopy = new HashMap<String,Integer>(wordFreqMap);
		
		while(!mapCopy.isEmpty() && mostFreqMap.size() < 5) {
			String freqWord = mostFrequentWord(mapCopy);
			mostFreqMap.put(freqWord, mapCopy.get(freqWord));
			mapCopy.remove(freqWord);
		}
		return mostFreqMap;
	}

	// Encuentra la palabra mas freqüente del conjunto
	private String mostFrequentWord(HashMap<String, Integer> map) {
		// Encontramos el valor maximo
		int max = 0;
		for (int value : map.values()) {
			if (value > max) {
				max = value;
			}
		}
		// Devolvemos la palabra
		for (String word : map.keySet()) {
			if (map.get(word) == max) {
				return word;
			}
		}
		return "";
	}

	
	boolean isPalindrome(String word) {
		int i = 0;
		int j = word.length() - 1;
		while (i < j) {
			if (word.charAt(i) != word.charAt(j)) {
				return false;
			}
			;
			i++;
			j--;
		}
		return true;
	}

	// Se encarga de eliminar espacios en blanco antes y despues de la frase y de
	// eliminar los puntos
	String totalTrim(String str) {
		str = str.trim();
		str = str.replace(",", " ");
		str = str.replaceAll("[\\.!?,]", "");
		return str;
	}
}
