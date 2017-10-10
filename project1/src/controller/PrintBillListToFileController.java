package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import model.Bill;
import model.Employee;

public class PrintBillListToFileController implements ActionListener {
  private ArrayList<Bill> listBill;
  private JTextPane txtBill;
  private Employee employee;
  /**
   * Constructor.
   * @param employee = employee
   * @param listBill = list bill
   * @param txtBill = txtBill
   */
  
  public PrintBillListToFileController(Employee employee, ArrayList<Bill> listBill, 
      JTextPane txtBill) {
    this.listBill = listBill;
    this.txtBill = txtBill;
    this.employee = employee;
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    employee.printListBillToFile(listBill);
    txtBill.setText(null);
    listBill.clear();
    JOptionPane.showMessageDialog(null, "Hoa don da duoc in!");
  }
}
