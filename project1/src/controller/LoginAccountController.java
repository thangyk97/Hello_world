package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.Account;
import model.ConnectDatabase;
import model.Employee;
import model.EmployeeInfo;
import model.EmployeeTimework;
import model.Manager;
import view.EmployeeView;
import view.ManagerView;

public class LoginAccountController implements ActionListener {
  private JTextField txtAccountName;
  private JPasswordField txtPassword;
  private JFrame frame;
  /**
   * This is constructor.
   * @param frame = frame
   * @param txtAccountName = txtAccountName
   * @param txtPassword = txtPassword
   */
  
  public LoginAccountController(JFrame frame, JTextField txtAccountName,
      JPasswordField txtPassword) {
    this.txtAccountName = txtAccountName;
    this.txtPassword = txtPassword;
    this.frame = frame;
  }
  
  @SuppressWarnings("deprecation")
  @Override
  
  public void actionPerformed(ActionEvent arg0) {
    if (this.txtAccountName.getText().equals("")) {
      JOptionPane.showMessageDialog(null,"Ban phai nhap vao tai khoan!");
      return;
    }
    if (this.txtPassword.getText().equals("")) {
      JOptionPane.showMessageDialog(null, "Ban phai nhap vao mat khau");
      return;
    }
    if (this.txtAccountName.getText().equals("root") && this.txtPassword.getText().equals("root")) {
      Manager manager = new Manager();
      EmployeeInfo managerInfo = new EmployeeInfo();
      Account managerAccount  = new Account();
      EmployeeTimework managerTimework = new EmployeeTimework();
      manager.setEmployeeAccount(managerAccount);
      manager.setEmployeeTimework(managerTimework);
      manager.setEmployeeInfo(managerInfo);
      ManagerView managerView = new ManagerView(manager);
      String num =  String.valueOf((ConnectDatabase.getNumberGoodsWithZeroAmount()));
      managerView.getBtnShowAmountZero().setText(" " + num + " sản phẩm đã hết hàng !");
      
      
      frame.dispose();
    } else {
      Account account = new Account();
      account.setAccountName(this.txtAccountName.getText());
      account.setPassword(this.txtPassword.getText());
      Employee employee = new Employee();
      employee.setEmployeeAccount(account);
      if (employee.tryLogin()) {
        employee.setEmployeeInfo(new EmployeeInfo());
        employee.setEmployeeTimework(new EmployeeTimework());
        ConnectDatabase.loadEmployeeInfo(employee);
        ConnectDatabase.loadEmployeeTimework(employee);
        employee.beginWork();
        EmployeeView employeeView = new EmployeeView(employee);
        employeeView.getTxtName().setText(employee.getEmployeeInfo().getName());
        employeeView.getTxtAges().setText(String.valueOf(employee.getEmployeeInfo().getAges()));
        employeeView.getTxtSex().setText(employee.getEmployeeInfo().getSex());
        employeeView.getTxtDateOfBirth().setText(employee.getEmployeeInfo().getDateOfBirth());
        employeeView.getTxtBegin().setText(employee.getEmployeeInfo().getDateBeginWork());
        employeeView.getLblEmployeeId().setText(employee.getEmployeeId());
        employeeView.getLblSalaryPerSession().setText(String.valueOf(employee.getEmployeeInfo()
            .getSalaryPerSession()));
        employeeView.getLblSessionCount().setText(String.valueOf(employee.getEmployeeTimework()
            .getSessionCount()));
        frame.dispose();
      } else {
        JOptionPane.showMessageDialog(null, "Login Fail");
        txtAccountName.setText(null);
        txtPassword.setText(null);
      }
    }
  }
}
