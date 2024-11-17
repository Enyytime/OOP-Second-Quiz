package predictive;

import java.io.IOException;

public class Sigs2WordsList {
  public static void main(String[] args) throws IOException {
    DictionaryListImpl dict = new DictionaryListImpl("D:/Code/Coding Stuff/2nd Year/Object Oriented Programming/Quiz2/QuizTwo/words");
    for (String signature : args) {
      System.out.println(signature + " : " + dict.signatureToWords(signature));
    }
  }
}
//"D:\Code\Coding Stuff\2nd Year\Object Oriented Programming\Quiz2\QuizTwo"