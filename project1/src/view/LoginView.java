package view;

import controller.LoginAccountController;
import controller.MoveToRegisterView;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginView {
  private JFrame frame;
  private JTextField txtTaiKhoan;
  private JButton btnRegister;
  private JLabel lblSupermarketManagementSys;
  private JPasswordField txtMatKhau;


  
  public LoginView() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(600, 200, 450, 359);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setVisible(true);
   
    
    JLabel lblTaiKhoan = new JLabel("Tài Khoản");
    lblTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
    lblTaiKhoan.setBounds(29, 118, 90, 25);
    frame.getContentPane().add(lblTaiKhoan);
    
    JLabel lblMatKhau = new JLabel("Mật Khẩu");
    lblMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
    lblMatKhau.setBounds(29, 157, 93, 25);
    frame.getContentPane().add(lblMatKhau);
    
    txtTaiKhoan = new JTextField();
    txtTaiKhoan.setBounds(174, 120, 193, 20);
    frame.getContentPane().add(txtTaiKhoan);
    txtTaiKhoan.setColumns(10);
    
    JButton btnLogin = new JButton("Đăng Nhập");
    btnLogin.setBounds(29, 212, 112, 23);
    frame.getContentPane().add(btnLogin);
    
    
    btnRegister = new JButton("Đăng Ký");
    btnRegister.setBounds(29, 252, 112, 23);
    frame.getContentPane().add(btnRegister);
    
    lblSupermarketManagementSys = new JLabel("SuperMarket Management Sys");
    lblSupermarketManagementSys.setHorizontalAlignment(SwingConstants.CENTER);
    lblSupermarketManagementSys.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblSupermarketManagementSys.setBounds(29, 39, 379, 32);
    frame.getContentPane().add(lblSupermarketManagementSys);

    txtMatKhau = new JPasswordField();
    txtMatKhau.setBounds(174, 161, 193, 20);
    frame.getContentPane().add(txtMatKhau);
    btnLogin.addActionListener(new LoginAccountController(frame, txtTaiKhoan, txtMatKhau));
    btnRegister.addActionListener(new MoveToRegisterView());
  }
}
