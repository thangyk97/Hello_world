package controller;

import javax.swing.JLabel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Employee;
import model.EmployeeInfo;
import view.ManagerView;

public class ShowEmployeeInfo implements ListSelectionListener {

  private JLabel[] lblGroup;
 
  private ManagerView managerView;
  
  
  /**
   * 
   * @param managerView is view of manager.
   * @param lblGroup is group label show employee information
   */
  
  public ShowEmployeeInfo(ManagerView managerView, JLabel[] lblGroup) {
    this.lblGroup = lblGroup;
    this.managerView = managerView;
  }
  
  @Override
  
  public void valueChanged(ListSelectionEvent arg0) {
    int index = managerView.getList().getSelectedIndex();
    Employee employee = managerView.getEmployeeList().get(index);
    EmployeeInfo info = employee.getEmployeeInfo();
    lblGroup[0].setText(info.getName());
    lblGroup[1].setText(String.valueOf(info.getAges()));
    lblGroup[2].setText(info.getSex());
    lblGroup[3].setText(info.getDateOfBirth());
    lblGroup[4].setText(info.getDateBeginWork());
    lblGroup[5].setText(employee.getEmployeeId());
    lblGroup[6].setText(String.valueOf(info.getSalaryPerSession()));
    lblGroup[7].setText(String.valueOf(employee.getEmployeeTimework().getSessionCount()));
  }

}
