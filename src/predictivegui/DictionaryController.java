package predictivegui;

/* this is controller in MVC. controller is basically to connect the view and the model
in short controller is the gateway, model is the backend view as the frontend, and it'll update the view
based on the interaction from view gets updated from the model
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DictionaryController {

  private DictionaryView view;
  private DictionaryModel model;

  //constructor
  public DictionaryController(DictionaryView view, DictionaryModel model) {
    this.view = view;
    this.model = model;

    //here we assign individual listeners to each button
    //with their respective commands
    this.view.addListener0(new Listener('0'));
    this.view.addListener1(new Listener('1'));
    this.view.addListener2(new Listener('2'));
    this.view.addListener3(new Listener('3'));
    this.view.addListener4(new Listener('4'));
    this.view.addListener5(new Listener('5'));
    this.view.addListener6(new Listener('6'));
    this.view.addListener7(new Listener('7'));
    this.view.addListener8(new Listener('8'));
    this.view.addListener9(new Listener('9'));
    this.view.addListenerStar(new Listener('*'));
    this.view.addListenerHash(new Listener('#'));
  }

  //initialize the view
  public void initView(String title) {

    this.view.initialize(title);
  }

  //ActionListener class for buttons
  class Listener implements ActionListener {
    private char command;

    public Listener(char command) {

      this.command = command;
    }

    public void actionPerformed(ActionEvent e) {
      //update the view
      view.setTextArea(model.buttonPress(command));
    }
  }
}