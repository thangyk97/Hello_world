package model;

import java.util.Date;

/**
 * 
 * @author Minh
 * @version 1.0
 *
 */

public class Account {
  private String employeeId;
  private String accountName;
  private String password;

  public Account() {
  }
  
  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }
  
  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public String getEmployeeId() {
    return this.employeeId;
  }
  
  public String getAccountName() {
    return accountName;
  }
  
  public String getPassword() {
    return password;
  }
  /**
   * 
   * @return identification code of employee.
   */
  
  public String  generateNewId() {
    Date date = new Date();
    this.employeeId = String.valueOf(date.getTime());
    return employeeId;
  }
}
