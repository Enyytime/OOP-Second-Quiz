package predictivegui;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import predictive.Dictionary;
import predictive.DictionaryTreeImpl;
import java.util.Collections;


public class DictionaryModel {
  private StringBuffer signatureBuilder = new StringBuffer("");
  private static Dictionary dictionary;
  private List<String> sig = new ArrayList<>();
  private List<String> selectedMatch = new ArrayList<>();
  private StringBuffer currentString = new StringBuffer("");
  private StringBuffer resp = new StringBuffer("");
  private int mark = 0;


  public DictionaryModel(String filepath) {
    try {
      dictionary = new DictionaryTreeImpl(filepath);
    } catch (Exception e) {
      System.err.println("Error loading dictionary: " + e.getMessage());
    }
  }

  // Handle button presses
  public String buttonPress(char chr) {
    switch (chr) {
      case '0':
        if (signatureBuilder.length() > 0) {
          processNewWord();
        }
        break;
      case '*':
        changeWord();
        updateCurrentWord();
        break;
      case '#':
        deleteCharacter();
        updateCurrentWord();
        break;
      case '1':
        // Button 1 does nothing
        break;
      default:
        addChar(chr);
        updateCurrentWord();
        break;
    }
    if (selectedMatch.isEmpty()) {
      return this.getResponse() + signatureBuilder.toString();
    }
    return this.getResponse() + selectedMatch.get(mark);
  }

  // Adjusted for mapping digits to characters and cycling through matches
  private void addChar(char chr) {
    // Add the digit to the signature builder
    signatureBuilder.append(chr);

    // Initialize or reset the selected matches list
    selectedMatch.clear();

    // Get the current prefix from the signature
    String currentPrefix = signatureBuilder.toString();

    // Call signatureToWords to get all possible words that have the signature as a substring
    Set<String> possibleWords = dictionary.signatureToWords(currentPrefix);

    // Print the possible words for debugging
    System.out.println("Possible words for signature '" + currentPrefix + "': " + possibleWords);

    // If matches are found, update the signature builder and selected matches
    if (!possibleWords.isEmpty()) {
      selectedMatch.addAll(possibleWords);

      // Sort the selected matches lexicographically
      Collections.sort(selectedMatch);

      // Reset the signature builder length to the current prefix length
      signatureBuilder.setLength(currentPrefix.length());
    } else {
      signatureBuilder.append(" (No matches)");
    }

    // Reset the marker to the first match
    resetMark();

    // Update the current word with the first match or indicate no matches
    updateCurrentWord();
  }

  // Update the selected matches to account for all words containing the signature as a substring
  private void updateSelectedMatches() {
    Set<String> matches = dictionary.signatureToWords(signatureBuilder.toString());
    selectedMatch = new ArrayList<>(matches);
    Collections.sort(selectedMatch);
  }

  private void resetMark() {
    mark = 0;
  }

  // Finalizes the current word, adds it to the response
  private void processNewWord() {
    if (signatureBuilder.length() > 0) {
      sig.add(signatureBuilder.toString());
      signatureBuilder.setLength(0);

      // Add the completed word to the response
      if (!currentString.isEmpty()) {
        resp.append(currentString).append(" ");
      }

      // Clear matches and reset current word
      selectedMatch.clear();
      currentString.setLength(0);
    }
  }

  // Update the current word in response after cycling
  private void updateCurrentWord() {
    if (!selectedMatch.isEmpty()) {
      currentString.setLength(0);
      currentString.append(selectedMatch.get(mark));
    } else {
      currentString.setLength(0);
      currentString.append("No matches found");
    }
  }

  // Handles the deletion of characters (backspace behavior)
  private void deleteCharacter() {
    if (signatureBuilder.length() > 0) {
      // Remove the last character from the current signature
      signatureBuilder.setLength(signatureBuilder.length() - 1);
    } else if (!sig.isEmpty()) {
      // If signature is empty, restore the last word's signature
      signatureBuilder.append(sig.remove(sig.size() - 1));

      // Remove the last word from the response
      int lastSpace = resp.lastIndexOf(" ");
      if (lastSpace != -1) {
        resp.setLength(lastSpace + 1);
      } else {
        resp.setLength(0);
      }
    }

    // Update matches and reset mark
    updateSelectedMatches();
    resetMark();
  }

  // Cycle through the matches
  private void changeWord() {
    if (!selectedMatch.isEmpty()) {
      mark = (mark + 1) % selectedMatch.size();
    }
  }

  // Returns the current response to be shown
  public String getResponse() {
    return resp.toString();
  }
}
