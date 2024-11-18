package predictive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DictionaryTreeImpl implements Dictionary{
  private Set<String> words;
  private DictionaryTreeImpl[] branches;

  public DictionaryTreeImpl() {
    this.words = new HashSet<>();
    this.branches = new DictionaryTreeImpl[8];
  }

  public DictionaryTreeImpl (String filepath) throws IOException {
    this();
    System.out.println("tes");
    readFile("words");
  }

  public void readFile(String filepath) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(filepath));
    String line;

    while((line = reader.readLine()) != null) {
      addWord(line.trim());
    }
    reader.close();
  }

  public void addWord(String word) {
    DictionaryTreeImpl current = this;

    String signature = wordToSignature(word);
    for(char digit: signature.toCharArray()) {
      int index = digit - '2';
      if(current.branches[index] == null) {
        current.branches[index] = new DictionaryTreeImpl();
      }

      current = current.branches[index];
      current.words.add(word);
    }
  }



  public void signatureToWordsRecursiveHelper(String signature, int index, Set<String> result, Set<String> seenWords){
    if(index == signature.length()){
      for(String word : words){
        if(word.length() == signature.length() && !seenWords.contains(word)){
          result.add(word.toLowerCase());
          seenWords.add(word);
        }
      }
      return;
    }
    char digit = signature.charAt(index);
    int branchIndex = digit - '2';
    if(branches[branchIndex] == null) return;

    branches[branchIndex].signatureToWordsRecursiveHelper(signature, index + 1, result, seenWords);
  }
  @Override
  public Set<String> signatureToWords(String signature){
    Set<String> seenWords = new HashSet<>();
    Set<String> result = new HashSet<>();
    signatureToWordsRecursiveHelper(signature, 0, result, seenWords);
    return result;
  }

  public String wordToSignature(String word) {
    StringBuilder signature = new StringBuilder();
    String[] keypad = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    for (char c : word.toLowerCase().toCharArray()) {
      for (int i = 0; i < keypad.length; i++) {
        if (keypad[i].contains(c + "")) {
          signature.append(i + 2);
          break;
        }
      }
    }
    return signature.toString();
  }
}
