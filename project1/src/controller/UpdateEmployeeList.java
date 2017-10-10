package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import model.Employee;
import model.Manager;
import view.ManagerView;

public class UpdateEmployeeList implements ActionListener {
 
  private Manager manager;
  private ManagerView managerView;
 
  public UpdateEmployeeList(ManagerView managerView, Manager manager) {
    this.manager = manager;
    this.managerView = managerView;
  }
  
  @Override
  
  public void actionPerformed(ActionEvent arg0) {
    ArrayList<Employee> employeeList = manager.getEmpoyeeList();
    Vector<String> employeeVector = new Vector<String>();
    
    for (Employee obj : employeeList) {
      employeeVector.addElement(obj.getEmployeeId() + "      " + obj.getEmployeeInfo().getName());
    }
    
    managerView.getList().setListData(employeeVector);
    managerView.setEmployeeList(employeeList);
  }

}
