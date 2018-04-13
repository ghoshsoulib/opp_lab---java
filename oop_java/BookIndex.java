

import java.io.*;
import java.util.*;

class Index {
	int line,pos;

	Index(int a,int b) {
		line = a;
		pos = b;
	}
	public String toString() {
		String str="[ Line = " + line + ", Position = " + pos + "]\n";
		return str;
	}
}

class BookIndex
{
	Map<String, ArrayList<Index> > hash_map_for_words;
	Map<List<String>, ArrayList<Index>> hash_map_for_phrases;

	BookIndex() {
		hash_map_for_words = new HashMap<>();
		hash_map_for_phrases = new HashMap<>();
	}

	public void createHashMapForWords(String path) {
		File fin = new File(path); 
		Scanner s = null;
		try {
			s = new Scanner(fin);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int line = 0, pos;
		
		while(s.hasNextLine()) {
			pos = 0;
			String str = s.nextLine();
			String arr[]=str.split("[ ,.]+", 0);
			for(int i = 0; i < arr.length; i++) {
				Index ob = new Index(line,pos);
				if(hash_map_for_words.containsKey(arr[i]) == false) {
					hash_map_for_words.put(arr[i], new ArrayList<Index>());
				}
				hash_map_for_words.get(arr[i]).add(ob);
				pos++;
			}
			line++;
		}
	}
	
	public void createHashMapForPhrases(String path, int len) {
		File fin = new File(path); 
		Scanner s = null;
		try {
			s = new Scanner(fin);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int line = 0, pos;
		
		while(s.hasNextLine()) {
			pos = 0;
			String str = s.nextLine();
			String arr[]=str.split("[ ,.]+", 0);
			for(int i = 0; i < arr.length - len + 1; i++) {
				Index ob = new Index(line, pos);
				List<String> temp = new ArrayList<String>();
				for(int j = i; j < (i + len); j++) {
					temp.add(arr[j]);
				}
				temp = Collections.unmodifiableList(temp);
				if(hash_map_for_phrases.containsKey(temp) == false) {
					hash_map_for_phrases.put(temp, new ArrayList<Index>());
				}
				hash_map_for_phrases.get(temp).add(ob);
				pos++;
			}
			line++;
		}
	}
	
	public static void main(String[] args) {
		BookIndex ob = new BookIndex();
		List<Index> result;
		int option;
		String path;
		Scanner s = new Scanner(System.in);
		do {
			
			System.out.println("1. Search for index of a word.");
			System.out.println("2. Search for index of a phrase.");
			System.out.println("3. Exit");
			System.out.print("\tEnter an option: ");
			
			option = Integer.parseInt(s.nextLine());
			switch(option) {
				case 1:
					System.out.println("\nEnter the absolute path of the file: ");
					System.out.print("PATH: ");
					path = s.nextLine();
					ob.createHashMapForWords(path);
					System.out.print("\nEnter word to search: ");
					String word = s.nextLine();
					result = ob.hash_map_for_words.get(word);
					if(result != null) {
						for(int i = 0; i < result.size(); i++) {
							System.out.print(result.get(i));
						}
						System.out.println();
					} else {
						System.out.println("\nThe word was not found.");
					}
					break;
				case 2:
					System.out.println("\nEnter the absolute path of the file: ");
					System.out.print("PATH: ");
					path = s.nextLine();
					System.out.print("\nEnter the length of the phrase: ");
					int len = Integer.parseInt(s.nextLine());
					ob.createHashMapForPhrases(path, len);
					System.out.print("Enter the phrase to search: ");
					String phrase = s.nextLine();
					String []temp = phrase.split("[ ,.]+", 0);
					List<String> search_key = new ArrayList<String>();
					for(int i = 0; i < temp.length; i++)
						search_key.add(temp[i]);
					search_key = Collections.unmodifiableList(search_key);
					result = ob.hash_map_for_phrases.get(search_key);
					if(result != null) {
						for(int i = 0; i < result.size(); i++) {
							System.out.print(result.get(i));
						}
						System.out.println();
					} else {
						System.out.println("\nThe phrase was not found.");
					}
					break;
				case 3:
					System.out.println("\n**********THANK YOU********\n");
					break;
				default:
					System.out.println("\nInvalid Entry.Try Again.");
					break;
			}
		} while(option != 3);
		s.close();
	}
}
