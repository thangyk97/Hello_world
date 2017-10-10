package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Employee;

public class LogOutController implements ActionListener {
  private JFrame frame;
  private Employee employee;
  /**
   * Constructor.
   * @param employee = employee
   * @param frame = frame
   */
  
  public LogOutController(Employee employee, JFrame frame) {
    // TODO Auto-generated constructor stub
    this.employee = employee;
    this.frame = frame;
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    employee.endWork();
    String noti = "";
    
    if (employee.getTimework() < 1) {
      noti = noti + "Ban chua lam du 1 ca lam viec. ";
    }
    
    int dialogResult = JOptionPane.showConfirmDialog(null,
        noti + "Ban chac chan muon ket thuc phien lam viec chu?");
    if (dialogResult == JOptionPane.YES_OPTION) {
      employee.saveSessionCount();
      frame.dispose();
    } else if (dialogResult == JOptionPane.CANCEL_OPTION) {
      return;
    }
  }

}
