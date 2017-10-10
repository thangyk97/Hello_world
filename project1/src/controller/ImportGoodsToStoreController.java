package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Goods;
import model.Manager;

public class ImportGoodsToStoreController implements ActionListener {
  private JTextField[] arrayJTextField;
  private JLabel lblCodeForNew;
  private JTextField txtAmount;
  private ArrayList<JComboBox<String>> comboBoxList;
  /**
   * This is constructor.
   * @param arrayJTextField = array
   * @param lblCodeForNew = label
   * @param comboBoxList = list
   * @param txtAmount = amount
   */
  
  public ImportGoodsToStoreController(JTextField[] arrayJTextField, JLabel lblCodeForNew,
      JTextField txtAmount, ArrayList<JComboBox<String>> comboBoxList) {
    // TODO Auto-generated constructor stub
    this.arrayJTextField = arrayJTextField;
    this.lblCodeForNew = lblCodeForNew;
    this.txtAmount = txtAmount;
    this.comboBoxList = comboBoxList;
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    for (int i = 0; i < 3; i ++) {
      if (arrayJTextField[i].getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Ban phai nhap du cac truong");
        return;
      }
    }
    
    if (txtAmount.getText().equals("")) {
      JOptionPane.showMessageDialog(null, "Ban phai nhap vao so luong");
      return;
    }
    
    String dateProduce = "";
    dateProduce = comboBoxList.get(0).getSelectedItem() + "-" 
        + comboBoxList.get(1).getSelectedItem() + "-"
        + comboBoxList.get(2).getSelectedItem();
    String dateExpire = "";
    dateExpire = comboBoxList.get(3).getSelectedItem() + "-" 
        + comboBoxList.get(4).getSelectedItem() + "-"
        + comboBoxList.get(5).getSelectedItem();
    Goods goods = new Goods();
    goods.setCode(lblCodeForNew.getText());
    goods.setName(arrayJTextField[0].getText());
    goods.setPrice(Integer.valueOf(arrayJTextField[1].getText()));
    goods.setDateProduce(dateProduce);
    goods.setDateExpire(dateExpire);
    goods.setProducer(arrayJTextField[2].getText());
    goods.setAmountRemain(Integer.valueOf(txtAmount.getText()));
    Manager root = new Manager();
    root.importGoods(goods);
    JOptionPane.showMessageDialog(null, "Thêm hàng thành công");
    for (int i = 0;i < 3; i++) {
      arrayJTextField[i].setText(null);
    }
    txtAmount.setText(null);
  }
}
