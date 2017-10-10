package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.ConnectDatabase;
import model.Employee;
import model.EmployeeInfo;
import view.EmployeeView;

public class SaveUpdateEmployeeInfoController implements ActionListener {

  private EmployeeView employeeView;
  private Employee employee;
  /**
   * Constructor.
   * @param employeeView = employeeView
   * @param employee = employee
   */
  
  public SaveUpdateEmployeeInfoController(EmployeeView employeeView, Employee employee) {
    // TODO Auto-generated constructor stub
    this.employeeView = employeeView;
    this.employee = employee;
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    EmployeeInfo employeeInfo = employee.getEmployeeInfo();
    employeeInfo.setName(employeeView.getTxtName().getText());
    employeeInfo.setAges(Integer.parseInt(employeeView.getTxtAges().getText()));
    employeeInfo.setSex(employeeView.getTxtSex().getText());
    employeeInfo.setDateOfBirth(employeeView.getTxtDateOfBirth().getText());
    employeeInfo.setDateBeginWork(employeeView.getTxtBegin().getText());
    ConnectDatabase.saveEmployeeInfo(employee);
    JOptionPane.showMessageDialog(null, "Du lieu da duoc luu!");
  }
}
