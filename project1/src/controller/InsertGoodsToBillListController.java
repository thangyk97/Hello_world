package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import model.Bill;
import model.ConnectDatabase;
import model.Employee;
import model.Goods;

public class InsertGoodsToBillListController implements ActionListener {
  private JTextField txtCode;
  private JTextPane txtBill;
  private JTextField txtAmount;
  private JLabel lblNotifications;
  private Employee employee;
  private ArrayList<Bill> listBill;
  /**
   * This is constructor.
   * @param employee = employee
   * @param listBill = list bill
   * @param txtCode = txtCode
   * @param txtAmount = txtAmount
   * @param txtBill = txtBill
   * @param lblNotifications = noti
   */
  
  public InsertGoodsToBillListController(Employee employee, ArrayList<Bill> listBill,
      JTextField txtCode, JTextField txtAmount, JTextPane txtBill, JLabel lblNotifications) {
    // TODO Auto-generated constructor stub
    this.txtCode = txtCode;
    this.txtBill = txtBill;
    this.txtAmount = txtAmount;
    this.lblNotifications = lblNotifications;
    this.employee = employee;
    this.listBill = listBill;
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    if (txtAmount.getText().equals("")) {
      JOptionPane.showMessageDialog(null, "Nhap vao so luong");
      return;
    }
    Goods goods = new Goods();
    goods.setCode(txtCode.getText());
    ConnectDatabase.loadGoodsInfo(goods);
    if (employee.checkGoodsIsAvailable(goods)) {
      int amount = Integer.parseInt(txtAmount.getText());
      lblNotifications.setText(null);
      listBill.add(employee.creatBill(goods, amount));
      int length = listBill.size();
      String txtListBill = "";
      for (int i = 0; i < length; i ++) {
        txtListBill = txtListBill + listBill.get(i).convertBillToString();
      }
      txtBill.setText(txtListBill);
      txtCode.setText(null);
      txtAmount.setText(null);
    } else {
      lblNotifications.setText("Ma hang ban nhap khong co trong kho");
    }
  }
}
