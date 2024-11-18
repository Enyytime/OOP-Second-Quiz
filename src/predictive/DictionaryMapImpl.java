package predictive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DictionaryMapImpl implements Dictionary {
  private Map<String, Set<String>> dictionaryMap;

  public DictionaryMapImpl(String filepath) throws IOException {
    this.dictionaryMap = new HashMap<>();
    readDictionary(filepath);
  }

  private void readDictionary(String filepath) throws IOException  {
    BufferedReader reader = new BufferedReader(new FileReader(filepath));
    String line;
    while ((line = reader.readLine()) != null) {
      String word = line.toLowerCase();
      if (!word.matches("^[a-z]+$")) {
        continue; // Skip words with non-alphabetic characters
      }
      String signature = wordToSignature(word);
      if(!dictionaryMap.containsKey(signature)) {
        dictionaryMap.put(signature, new HashSet<>());
      }
      dictionaryMap.get(signature).add(word);
    }
    reader.close();
  }

  @Override
  public Set<String> signatureToWords(String signature){
    Set<String> words = dictionaryMap.get(signature);
    Set<String> result = new HashSet<>();
    if(words != null){
      for(String word : words){
        result.add(word);
      }
    }
    return result;
  }
  public static String wordToSignature(String word){
    return PredictivePrototype.wordToSignature(word); // ehehehehhe
  }
}
