package loremipsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Esta clase se encarga de recorrer el texto y hacer las operaciones
 * pertinentes con él
 **/
public class Crawler {

	public ArrayList<String> paragraphs;
	public ArrayList<String> phrases;
	public ArrayList<String> words;
	public ArrayList<String> palindromes;
	public HashMap<String, Integer> wordFreqMap;
	public HashMap<String, Integer> tupleFreqMap;
	public HashMap<String, Integer> mostFreqWords;
	private HashMap<String, Integer> mostFreqTuples;

	// Constructor
	public Crawler(ArrayList<String> paragraphs) {
		this.paragraphs = paragraphs;
		this.phrases = getPhrasesList();
		this.words = getWordList();
		this.palindromes = getPalindromeList();
		this.wordFreqMap = getWordFrequency();
		this.tupleFreqMap = getTupleFrequency();
		this.mostFreqWords = getMostFrequentWords();
		this.mostFreqTuples = getMostFrequentTuples();
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

	public HashMap<String, Integer> getMostFrequentWords() {
		return mostFrequentKeys(wordFreqMap);
	}
	
	public HashMap<String, Integer> getMostFrequentTuples() {
		return mostFrequentKeys(tupleFreqMap);
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
	private HashMap<String, Integer> mostFrequentKeys(HashMap<String, Integer> map) {
		HashMap<String, Integer> mostFreqMap = new HashMap<String, Integer>();
		HashMap<String, Integer> mapCopy = new HashMap<String, Integer>(map);

		while (!mapCopy.isEmpty() && mostFreqMap.size() < 5) {
			String freqWord = mostFrequentKey(mapCopy);
			mostFreqMap.put(freqWord, mapCopy.get(freqWord));
			mapCopy.remove(freqWord);
		}
		return mostFreqMap;
	}

	// Encuentra la palabra mas freqüente del conjunto
	private String mostFrequentKey(HashMap<String, Integer> map) {
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

	// Creamos las tuplas y las almacenamos en un mapa
	private HashMap<String, Integer> getTupleFrequency() {
		HashMap<String, Integer> tupleMap = new HashMap<String, Integer>();
		int i = 1;
		while (i < words.size()) {
			String tuple = convertToTuple(words.get(i - 1), words.get(i));
			tupleMap.compute(tuple, (key, value) -> (value == null) ? 1 : value + 1);
		i++;
		}
		System.out.println(tupleMap);
		return tupleMap;
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

	// Se encarga de eliminar espacios en blanco, antes y despues de la frase, y de
	// eliminar los puntos
	String totalTrim(String str) {
		str = str.trim();
		str = str.replace(",", " ");
		str = str.replaceAll("[\\.!?,]", "");
		return str;
	}

	// Concatenamos las palabras separadas por coma para crear la pareja
	String convertToTuple(String first, String second) {
		return first + ", " + second;
	}
}
