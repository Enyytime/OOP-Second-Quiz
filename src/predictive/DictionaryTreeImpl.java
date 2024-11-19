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



  public void signatureToWordsRecursiveHelper(String signature, int index, Set<String> result, Set<String> seenWords) {
    if (index == signature.length()) {
      // Iterate through all words and check for the signature match
      for (String word : words) {
        // Check for all possible substrings in the word
        for (int start = 0; start < word.length(); start++) {
          for (int end = start + 1; end <= word.length(); end++) {
            String substring = word.substring(start, end);

            // Ensure the substring contains only alphabetic characters
            if (substring.matches("[a-zA-Z]+")) {
              String substringSignature = wordToSignature(substring); // Get the signature of the substring

              // If the substring's signature matches and it's not already seen, add it to the result
              if (substringSignature.equals(signature) && !seenWords.contains(substring)) {
                result.add(substring.toLowerCase());
                seenWords.add(substring);
              }
            }
          }
        }
      }
      return;
    }

    // Process each digit in the signature recursively
    char digit = signature.charAt(index);
    int branchIndex = digit - '2';
    if (branches[branchIndex] == null) return;

    // Continue the recursion down the tree
    branches[branchIndex].signatureToWordsRecursiveHelper(signature, index + 1, result, seenWords);
  }

  @Override
  public Set<String> signatureToWords(String signature) {
    Set<String> seenWords = new HashSet<>();
    Set<String> result = new HashSet<>();
    signatureToWordsRecursiveHelper(signature, 0, result, seenWords);
    return result;
  }



  //
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

  // Method to print the tree recursively
  public void printTree(String prefix) {
    // Print current level words
    if (!words.isEmpty()) {
      System.out.println(prefix + " -> " + words);
    }

    // Recursively print the children nodes (branches)
    for (int i = 0; i < branches.length; i++) {
      if (branches[i] != null) {
        branches[i].printTree(prefix + " -> " + (char)('2' + i)); // Printing current branch number
      }
    }
  }

}
