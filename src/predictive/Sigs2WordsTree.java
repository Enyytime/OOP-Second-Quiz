package predictive;

import java.io.IOException;
import java.util.Set;

public class Sigs2WordsTree {
  public static void main(String[] args) throws IOException {
    String filepath = "words";

    // Initialize the tree-based dictionary
    DictionaryTreeImpl dictionaryTree = new DictionaryTreeImpl(filepath);

    // Time the signature to words lookup
    long startTime = System.nanoTime();

    for (String signature : args) {
      Set<String> words = dictionaryTree.signatureToWords(signature);
      System.out.println(signature + " : " + words);
    }

    long endTime = System.nanoTime();
    long duration = endTime - startTime;
    System.out.println("Time taken: " + duration + " nanoseconds");
  }
}