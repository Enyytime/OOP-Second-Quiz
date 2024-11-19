package predictivegui;

import java.awt.*;
import javax.swing.*;

public class MainPanel extends JPanel {
  protected JTextArea text = new JTextArea();
  protected JButton button1 = new JButton("1");
  protected JButton button2 = new JButton("2 abc");
  protected JButton button3 = new JButton("3 def");
  protected JButton button4 = new JButton("4 ghi");
  protected JButton button5 = new JButton("5 jkl");
  protected JButton button6 = new JButton("6 mno");
  protected JButton button7 = new JButton("7 pqrs");
  protected JButton button8 = new JButton("8 tuv");
  protected JButton button9 = new JButton("9 wxyz");
  protected JButton buttonStar = new JButton("*");
  protected JButton button0 = new JButton("0 _");
  protected JButton buttonHash = new JButton("#");

  public MainPanel() {
    // make a grid for the layout
    GridLayout layout = new GridLayout(5, 1);

    setLayout(layout);

    // here we have 5 container for the grid
    JPanel row1 = new JPanel();
    JPanel row2 = new JPanel();
    JPanel row3 = new JPanel();
    JPanel row4 = new JPanel();
    JPanel row5 = new JPanel();

    // size of the button and text field
    Dimension buttonSize = new Dimension(100, 65);
    button0.setPreferredSize(buttonSize);
    button1.setPreferredSize(buttonSize);
    button2.setPreferredSize(buttonSize);
    button3.setPreferredSize(buttonSize);
    button4.setPreferredSize(buttonSize);
    button5.setPreferredSize(buttonSize);
    button6.setPreferredSize(buttonSize);
    button7.setPreferredSize(buttonSize);
    button8.setPreferredSize(buttonSize);
    button9.setPreferredSize(buttonSize);
    buttonStar.setPreferredSize(buttonSize);
    buttonHash.setPreferredSize(buttonSize);
    text.setColumns(23);
    text.setRows(5);
    text.setText("predictive text: enter text with 8 keys.");

    // set background colors
    setBackground(Color.white);
    row1.setBackground(Color.lightGray);
    row2.setBackground(Color.white);
    row3.setBackground(Color.white);
    row4.setBackground(Color.white);
    row5.setBackground(Color.white);

    // set text area background color
    text.setBackground(Color.white);

    // add the components to the container
    row1.add(text);
    row2.add(button1);
    row2.add(button2);
    row2.add(button3);
    row3.add(button4);
    row3.add(button5);
    row3.add(button6);
    row4.add(button7);
    row4.add(button8);
    row4.add(button9);
    row5.add(buttonStar);
    row5.add(button0);
    row5.add(buttonHash);

    // add the container to the grid
    add(row1);
    add(row2);
    add(row3);
    add(row4);
    add(row5);

    text.setEditable(false);
    text.setLineWrap(true);
  }

  public void setText(String value) {
    text.setText(value);
  }
}


