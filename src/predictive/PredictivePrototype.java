package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PredictivePrototype {

    //    public static String wordToSignature(String word) {
    //        StringBuilder signature = new StringBuilder();
    //        String[] keypad = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    //        for(char c : word.toLowerCase().toCharArray()) {
    //            for(int i = 0; i < keypad.length; i++) {
    //                if(keypad[i].contains(c + "")){
    //                    signature.append(i + 2);
    //                    break;
    //                }
    //            }
    //        }
    //        return signature.toString();
    //    }
    // timewise, this fucntion is faster by a small margin than the top one ehehehehhehe
    public static String wordToSignature(String word){
        StringBuilder signature = new StringBuilder();
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            c = toLowercase(c);
            if(c >= 'a' && c <= 'c'){
                signature.append('2');
            }
            else if(c >= 'd' && c <= 'f'){
                signature.append('3');
            }
            else if (c >= 'g' && c <= 'i') {
                signature.append('4');
            }
            else if (c >= 'j' && c <= 'l') {
                signature.append('5');
            }
            else if (c >= 'm' && c <= 'o') {
                signature.append('6');
            }
            else if (c >= 'p' && c <= 's') {
                signature.append('7');
            }
            else if (c >= 't' && c <= 'v') {
                signature.append('8');
            }
            else if (c >= 'w' && c <= 'z') {
                signature.append('9');
            }
            else {
                signature.append(' ');
            }
        }
        return signature.toString();
    }


    public static Set<String> signatureToWords(String signature){
        Set<String> words = new HashSet<>();

        try{
            File dictionary = new File("words"); // scan the words file
            Scanner scan = new Scanner(dictionary); // then put it inside a scanner, so the code can read the file
            while(scan.hasNextLine()){
                String word = scan.nextLine().toLowerCase();
                if(isValidWord(word)){
                    String wordSignature = wordToSignature(word); // change the word into signature

                    if(wordSignature.equals(signature)){ //and if the word's signature is the same, we add to the results
                        words.add(word);
                    }
                }
            }
        } catch(FileNotFoundException e){
            System.out.println("Dictionary file not found!");
        }
        return words;
    }

    private static boolean isValidWord(String word) {
        return word.matches("[a-zA-Z]+");
    }
    // i made this when i i didn't know there's a toLowercase function in the String datatype
    public static char toLowercase(char c) {
        if (c == 'A') {
            return 'a';
        } else if (c == 'B') {
            return 'b';
        } else if (c == 'C') {
            return 'c';
        } else if (c == 'D') {
            return 'd';
        } else if (c == 'E') {
            return 'e';
        } else if (c == 'F') {
            return 'f';
        } else if (c == 'G') {
            return 'g';
        } else if (c == 'H') {
            return 'h';
        } else if (c == 'I') {
            return 'i';
        } else if (c == 'J') {
            return 'j';
        } else if (c == 'K') {
            return 'k';
        } else if (c == 'L') {
            return 'l';
        } else if (c == 'M') {
            return 'm';
        } else if (c == 'N') {
            return 'n';
        } else if (c == 'O') {
            return 'o';
        } else if (c == 'P') {
            return 'p';
        } else if (c == 'Q') {
            return 'q';
        } else if (c == 'R') {
            return 'r';
        } else if (c == 'S') {
            return 's';
        } else if (c == 'T') {
            return 't';
        } else if (c == 'U') {
            return 'u';
        } else if (c == 'V') {
            return 'v';
        } else if (c == 'W') {
            return 'w';
        } else if (c == 'X') {
            return 'x';
        } else if (c == 'Y') {
            return 'y';
        } else if (c == 'Z') {
            return 'z';
        }
        return c;
    }
}
