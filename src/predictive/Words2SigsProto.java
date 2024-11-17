package predictive;

public class Words2SigsProto {
    public static void main(String[] args) {
        System.out.print("input : ");
        for (String word : args) {
            System.out.print(word + " ");
        }
        System.out.println();
        System.out.print("output : ");
        for (String word : args) {
            System.out.print(PredictivePrototype.wordToSignature(word) + " ");
        }
        System.out.println();
    }
}