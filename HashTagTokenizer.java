

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		for(int j = 0; j< 3000; j++){
		dictionary[j] = in.readString();

	    }  
		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {
		word = word.toLowerCase();
		
		for(int j = 0 ; j < dictionary.length; j++)
		{
			if(word.equals(dictionary[j]))
			return true;
		}
		return false;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {

		
        if (hashtag.isEmpty()) {
            return;
        }
 
        int N = hashtag.length();
String word = "";
        for (int j= 1; j <= N; j++) {
		char ch = hashtag.charAt(j-1);
		 word = word + ch;
			if(existInDictionary(word, dictionary))
			{
				System.out.println(word);
				breakHashTag(hashtag.substring(j), dictionary);
			}
        }return;
	}	
       
}
