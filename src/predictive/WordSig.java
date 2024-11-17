package predictive;

public class WordSig implements Comparable<WordSig> {
  private String words;
  private String signature;

  public WordSig(String words, String signature){
    this.words = words;
    this.signature = signature;
  }

  public String getWord(){
    return words;
  }

  public String getSignature(){
    return signature;
  }

  @Override
  public int compareTo(WordSig ws) {
    return this.signature.compareTo(ws.signature); //usefull for binary searching
  }
  public String toString() {
    return words + ": " + signature;
  }
}
