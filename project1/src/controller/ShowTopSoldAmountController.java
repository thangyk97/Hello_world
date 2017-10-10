package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextPane;

import model.ConnectDatabase;
import model.Goods;

public class ShowTopSoldAmountController implements ActionListener {
  private JTextPane txtTopGoods;
  private JComboBox<String> comboBox;
  /**
   * Constructor.
   * @param comboBox = comboBox
   * @param txtTopGoods = txtTopGoods
   */
  
  public ShowTopSoldAmountController(JComboBox<String> comboBox, JTextPane txtTopGoods) {
    this.txtTopGoods = txtTopGoods;
    this.comboBox = comboBox;
    // TODO Auto-generated constructor stub
  }
  
  @Override
  public void actionPerformed(ActionEvent arg0) {
    // TODO Auto-generated method stub
    int amount = Integer.valueOf(comboBox.getSelectedItem().toString());
    String txt = "";
    ArrayList<Goods> goods  = ConnectDatabase.getTop(amount);
    
    for (int i = 0; i < goods.size(); i ++) {
      txt = txt + goods.get(i).toString();
    }
    txtTopGoods.setText(txt);
  }
}
