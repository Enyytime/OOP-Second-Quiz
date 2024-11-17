package predictive;

import java.util.Set;

public class Sigs2WordsProto {
    public static void main(String[] args) {
        for (String signature : args) {
            Set<String> words = PredictivePrototype.signatureToWords(signature);

            // Print each signature followed by its corresponding matching words
            System.out.print(signature + " : ");
            for (String word : words) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }
}
