package predictivegui;

/*  this class is to display the user interface and handle user input events. 
    this class contains methods for initializing the frame, adding action listeners to buttons,
    and updating the text area based on the provided string. */

import java.awt.event.ActionListener;
import javax.swing.*;

public class DictionaryView {

  private MainPanel MainPanel = new MainPanel();

  public void initialize(String title) {
    JFrame frame = new JFrame(title);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setContentPane(MainPanel);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    frame.setResizable(false);

    //addActionListeners();
  }

  private void addActionListener(JButton button, ActionListener listener) {
    button.addActionListener(listener);
  }

  public void addListener0(ActionListener listener) {
    addActionListener(MainPanel.button0, listener);
  }

  public void addListener1(ActionListener listener) {
    addActionListener(MainPanel.button1, listener);
  }

  public void addListener2(ActionListener listener) {
    addActionListener(MainPanel.button2, listener);
  }

  public void addListener3(ActionListener listener) {
    addActionListener(MainPanel.button3, listener);
  }

  public void addListener4(ActionListener listener) {
    addActionListener(MainPanel.button4, listener);
  }

  public void addListener5(ActionListener listener) {
    addActionListener(MainPanel.button5, listener);
  }

  public void addListener6(ActionListener listener) {
    addActionListener(MainPanel.button6, listener);
  }

  public void addListener7(ActionListener listener) {
    addActionListener(MainPanel.button7, listener);
  }

  public void addListener8(ActionListener listener) {
    addActionListener(MainPanel.button8, listener);
  }

  public void addListener9(ActionListener listener) {
    addActionListener(MainPanel.button9, listener);
  }

  public void addListenerStar(ActionListener listener) {
    addActionListener(MainPanel.buttonStar, listener);
  }

  public void addListenerHash(ActionListener listener) {
    addActionListener(MainPanel.buttonHash, listener);
  }

  public void setTextArea(String text) {
    MainPanel.text.setText(text);
  }

}
