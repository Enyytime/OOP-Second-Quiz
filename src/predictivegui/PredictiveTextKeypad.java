package predictivegui;

/* now, we implement a simple application which follows the MVC design pattern.
 * this will represent the predictive text entry system.
 */

public class PredictiveTextKeypad {

  public static void main(String[] args) {
    DictionaryModel Model = new DictionaryModel("words");
    DictionaryView View = new DictionaryView();
    DictionaryController Controller = new DictionaryController(View, Model);

    Controller.initView("Predictive Text");

  }
}
