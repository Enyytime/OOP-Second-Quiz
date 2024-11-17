package predictive;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class DictionaryListImpl {
  private ArrayList<WordSig> dictionary;


  public DictionaryListImpl(String filepath) throws IOException {
    dictionary = new ArrayList<>();
    readDictionary(filepath);
    Collections.sort(dictionary);
  }

  private void readDictionary(String filepath) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(filepath));

    String line;
    while((line = reader.readLine()) != null)  {
      String word = line.toLowerCase();
      if (!word.matches("^[a-z]+$")){
        continue;
      }
      String signature = wordToSignature(word);

      dictionary.add(new WordSig(word, signature));
    }
    reader.close();
  }

  public static String wordToSignature(String word){

    return PredictivePrototype.wordToSignature(word); // ehehehehhe
  }

  public int STWRecursion(String signature, int left, int right) {
    if (left <= right) {
      int mid = left + (right - left) / 2;
      String midSignature = dictionary.get(mid).getSignature();

      if (midSignature.equals(signature)) {
//        System.out.println("found");
//        System.out.println("index : " + mid);
        return mid;  // Return the found index
      }

      if (midSignature.compareTo(signature) > 0) {
        return STWRecursion(signature, left, mid - 1);  // Recurse left
      } else {
        return STWRecursion(signature, mid + 1, right);  // Recurse right
      }
    }
    return -1;  // Return -1 if the signature is not found
  }
  public List<String> signatureToWords(String signature){
    List<String> result = new ArrayList<>();
    Set<String> seenWords = new HashSet<>();
    int left = 0;
    int right = dictionary.size() - 1;

    int index = 0;
    index = STWRecursion(signature, left, right);
    if(index != -1){
      int position = index;
      while(position >= 0 && dictionary.get(position).getSignature().equals(signature)){
        String word = dictionary.get(position).getWord();

        if(!seenWords.contains(word)){
          result.add(word);

//          System.out.println("added");
          seenWords.add(word);
        }

        position--;
      }
      position = index + 1;
      while(position < dictionary.size() && dictionary.get(position).getSignature().equals(signature)){
        String word = dictionary.get(position).getWord();

        if(!seenWords.contains(word)){
          result.add(word);
          seenWords.add(word);
        }

        position++;
      }
    }
    return result;
  }
}
