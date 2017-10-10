package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class GenerateCodeForGoodsController implements ActionListener {
  //private JTextField[] arrayJTextField;
  private JLabel lblCodeForNew;
  /**
   * This is constructor.
   * @param arrayJTextField = arrayJTextField
   * @param lblCodeForNew = lblCodeForNew
   */
  
  public GenerateCodeForGoodsController(JTextField[] arrayJTextField, JLabel lblCodeForNew) {
    // TODO Auto-generated constructor stub
    //this.arrayJTextField = arrayJTextField;
    this.lblCodeForNew = lblCodeForNew;
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    Date date = new Date();
    lblCodeForNew.setText(date.toString());

  }

}
