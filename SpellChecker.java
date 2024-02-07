
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) {
		str = str.substring(1);
		return str;
	}

	public static int levenshtein(String word1, String word2) {
		 word1 = word1.toLowerCase();
		 word2 = word2.toLowerCase();

		 if (word1.charAt(0)== word2.charAt(0)){
           return levenshtein (tail(word1), tail(word2));
	     }

        else if( word1.isEmpty() || word2.isEmpty()){
           return (Math.max (word1.lenght(),word2.lenght()));
        
        } 

	     else {

			return 1 + (Math.min(levenshtein(tail(word1), tail(word2)),Math.min(levenshtein((word1), tail(word2)),levenshtein(tail(word1), (word2))))); 
			}
		}	

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		for(int j = 0; j < 3000; j++){
		dictionary[j] = in.readString();

	    }  

		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		String correct = word;
			int currentTresh=0;
			int smallest = threshold+1;
		for(int j = 0; j < dictionary.length; j++) {
			currentTresh = levenshtein(dictionary[j], word);
			if(currentTresh <= threshold && currentTresh != smallest )
			{
				correct = dictionary[j];
				smallest = currentTresh;
			}
		}
		return correct;
	}

}
