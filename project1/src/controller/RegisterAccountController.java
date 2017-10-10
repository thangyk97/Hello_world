package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Account;
import model.ConnectDatabase;

public class RegisterAccountController implements ActionListener {
  private JTextField txtId;
  private JTextField txtAccountName;
  private JPasswordField txtPassword;
  private JFrame frame;
  private JPasswordField txtPassword1;
  /**
   * Constructor.
   * @param frame = frame
   * @param txtId = txtId
   * @param txtAccountName = txtAccountName
   * @param txtPassword = txtPassword
   * @param txtPassword1 is the fifth parameter
   */
  
  public RegisterAccountController(JFrame frame, JTextField txtId, JTextField txtAccountName, 
      JPasswordField txtPassword, JPasswordField txtPassword1) {
    // TODO Auto-generated constructor stub
    this.txtId = txtId;
    this.txtAccountName = txtAccountName;
    this.txtPassword = txtPassword;
    this.txtPassword1 = txtPassword1;
    this.frame = frame;
  }

  @SuppressWarnings("deprecation")
  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    if (!(txtPassword.getText().equals(txtPassword1.getText()))) {
      JOptionPane.showMessageDialog(null, "Mật Khẩu Không Chính Xác");
      return;
    }
    Account account = new Account();
    account.setAccountName(txtAccountName.getText());
    account.setEmployeeId(txtId.getText());
    System.out.println(account.getEmployeeId());
    account.setPassword(txtPassword.getText());
    if (ConnectDatabase.isLegalIdToRegister(account)) {
      if (ConnectDatabase.isLegalAccountName(account)) {
        ConnectDatabase.savaAccountInfo(account);;
        JOptionPane.showMessageDialog(null, "Đăng Ký Thành Công! ");
        frame.dispose();
      } else {
        JOptionPane.showMessageDialog(null, "Tên tài khoản đã tồn tại! ");
      }
    } else {
      JOptionPane.showMessageDialog(null, "ID không hợp lệ! ");
    }
  }
}
