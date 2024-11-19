package predictivegui;

/*
* this part is too start the application by combining the Dictionary MVC
*
* */

public class PredictiveTextKeypad {

  public static void main(String[] args) {
    DictionaryModel Model = new DictionaryModel("words");
    DictionaryView View = new DictionaryView();
    DictionaryController Controller = new DictionaryController(View, Model);

    Controller.initView("Predictive Text");

  }
}
