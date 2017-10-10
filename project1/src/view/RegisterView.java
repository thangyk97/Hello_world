package view;

import controller.RegisterAccountController;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterView {
  private JFrame frame;
  private JTextField txtId;
  private JTextField txtAccountName;
  private JPasswordField txtPassword1;
  private JPasswordField txtPassword;
  
  public RegisterView() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(600, 200, 450, 359);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setVisible(true);
    
    JLabel lblTaiKhoan = new JLabel("Tài Khoản");
    lblTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblTaiKhoan.setBounds(30, 130, 89, 20);
    frame.getContentPane().add(lblTaiKhoan);
    
    JLabel lblMatKhau = new JLabel("Mật Khẩu");
    lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblMatKhau.setBounds(33, 210, 86, 20);
    frame.getContentPane().add(lblMatKhau);
    
    JLabel lblId = new JLabel("ID");
    lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblId.setBounds(33, 90, 86, 20);
    frame.getContentPane().add(lblId);
    
    JLabel label = new JLabel("Mật Khẩu");
    label.setFont(new Font("Tahoma", Font.BOLD, 14));
    label.setBounds(33, 170, 86, 20);
    frame.getContentPane().add(label);
 
    
    txtAccountName = new JTextField();
    txtAccountName.setColumns(10);
    txtAccountName.setBounds(161, 130, 175, 20);
    frame.getContentPane().add(txtAccountName);
    
    txtId = new JTextField();
    txtId.setBounds(161, 90, 175, 20);
    frame.getContentPane().add(txtId);
    txtId.setColumns(10);
  
    
    txtPassword = new JPasswordField();
    txtPassword.setBounds(161, 170, 175, 20);
    frame.getContentPane().add(txtPassword);
    
    txtPassword1 = new JPasswordField();
    txtPassword1.setFont(new Font("Tahoma", Font.BOLD, 11));
    txtPassword1.setBounds(161, 210, 175, 20);
    frame.getContentPane().add(txtPassword1);
    
    
    
    JButton btnRegister = new JButton("Đăng Ký");
    btnRegister.setFont(new Font("Tahoma", Font.BOLD, 14));
    btnRegister.setBounds(33, 265, 107, 23);
    frame.getContentPane().add(btnRegister);
    
    btnRegister.addActionListener(new RegisterAccountController(frame, txtId, txtAccountName,
        txtPassword, txtPassword1));
  }
}
