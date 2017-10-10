package model;

public class EmployeeInfo {
  private String name;
  private int ages;
  private String sex;
  private String dateOfBirth;
  private String dateBeginWork;
  private int salaryPerSession;

  public EmployeeInfo() {}

  public String getName() {
    return name;
  }



  public void setName(String name) {
    this.name = name;
  }



  public int getAges() {
    return ages;
  }



  public void setAges(int ages) {
    this.ages = ages;
  }



  public String getSex() {
    return sex;
  }



  public void setSex(String sex) {
    this.sex = sex;
  }



  public String getDateOfBirth() {
    return dateOfBirth;
  }



  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }



  public String getDateBeginWork() {
    return dateBeginWork;
  }



  public void setDateBeginWork(String dateBeginWork) {
    this.dateBeginWork = dateBeginWork;
  }



  public int getSalaryPerSession() {
    return salaryPerSession;
  }



  public void setSalaryPerSession(int salaryPerSession) {
    this.salaryPerSession = salaryPerSession;
  }


  /**
   * This method change employee's salary.
   * @param salaryPerSession = salary
   * @param employeeId = employeeId
   */
  public void changeSalaryPerSession(int salaryPerSession, String employeeId) {
    this.salaryPerSession = salaryPerSession;
    ConnectDatabase conn = new ConnectDatabase();
    String sqlQuery = "UPDATE `employeeinfo_tb` SET `salaryPerSession` = '" + this.salaryPerSession 
        + "' WHERE `employeeinfo_tb`.`employeeID` = '" + employeeId + "'";
    conn.executeQuery(sqlQuery);
  }
}
