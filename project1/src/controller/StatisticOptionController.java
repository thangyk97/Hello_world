package controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import model.ConnectDatabase;
import model.Goods;

public class StatisticOptionController implements ItemListener {
  private JComboBox<String> com1;
  private JComboBox<String> com2;
  private JTextPane txtTopGoods;
  /**
   * Constructor.
   * @param com1 = com1
   * @param com2 = com2
   * @param txtTopGoods = txtTopsGoods
   */
  
  public StatisticOptionController(JComboBox<String> com1, JComboBox<String> com2, 
      JTextPane txtTopGoods) {
    // TODO Auto-generated constructor stub
    this.com1 = com1;
    this.com2 = com2;
    this.txtTopGoods = txtTopGoods;
  }
  
  @Override
  public void itemStateChanged(ItemEvent e) {
    // TODO Auto-generated method stub
    if (com2.getSelectedIndex() == 1) {
      int amount = Integer.valueOf(com1.getSelectedItem().toString());
      String txt = "";
      ArrayList<Goods> goods  = ConnectDatabase.getTop(amount);
      
      for (int i = 0; i < goods.size(); i ++) {
        txt = txt + goods.get(i).toString();
      }
      txtTopGoods.setText(txt);
    } else if (com2.getSelectedIndex() == 2) {
      int amount = Integer.valueOf(com1.getSelectedItem().toString());
      String txt = "";
      ArrayList<Goods> goods  = ConnectDatabase.getBot(amount);
      
      for (int i = 0; i < goods.size(); i ++) {
        txt = txt + goods.get(i).toString();
      }
      txtTopGoods.setText(txt);
    } else if (com2.getSelectedIndex() == 3) {
      ArrayList<Goods> goods  = ConnectDatabase.getListGoodsWithZeroAmount();
      String txt = "";
      for (int i = 0; i < goods.size(); i ++) {
        txt = txt + goods.get(i).toString();
      }
      txtTopGoods.setText(txt);
    } else if (com2.getSelectedIndex() == 4) {
      ArrayList<Goods> goods = ConnectDatabase.getListGoodsHetHan();
      String txt = "";
      for (int i = 0; i < goods.size(); i ++) {
        txt = txt + goods.get(i).toString();
      }
      txtTopGoods.setText(txt);
    }
  }

}
