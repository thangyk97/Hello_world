package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
/**
 * This class is employee's information.
 * @author minhminh
 *
 */

public class Employee {
  private EmployeeInfo employeeInfo;
  private Account employeeAccount;
  private EmployeeTimework employeeTimework;

  public Employee() {}

  public void setEmployeeAccount(Account employeeAccount) {
    this.employeeAccount = employeeAccount;
  }
  
  public void setEmployeeInfo(EmployeeInfo employeeInfo) {
    this.employeeInfo = employeeInfo;
  }
  
  public void setEmployeeTimework(EmployeeTimework employeeTimework) {
    this.employeeTimework = employeeTimework;
  }
  
  public EmployeeInfo getEmployeeInfo() {
    return this.employeeInfo;
  }
  
  public EmployeeTimework getEmployeeTimework() {
    return this.employeeTimework;
  }

  public Account getAccount() {
    return this.employeeAccount;
  }

  public String getEmployeeId() {
    return this.employeeAccount.getEmployeeId();
  }
  /**
   *This method check if employee login successfully. 
   * @return boolean value
   */
  
  public boolean tryLogin() {
    if (ConnectDatabase.isRegisterAccount(this.employeeAccount)) {
      return true;
    } else {
      return false;
    }
  }
  /**
   * This method change employee's account's password.
   * @param password = password
   */
  
  public void changePassword(String password) {
    this.employeeAccount.setPassword(password);
    ConnectDatabase.savaAccountInfo(this.employeeAccount);;
  }
  
  public void beginWork() {
    this.employeeTimework.beginWork();
  }
  
  public void endWork() {
    this.employeeTimework.endWork();
  }
  
  public int getTimework() {
    return employeeTimework.getTimework();
  }
  
  public boolean checkGoodsIsAvailable(Goods goods) {
    return ConnectDatabase.isAvailable(goods);
  }

  public int countSalary() {
    return this.employeeInfo.getSalaryPerSession() * this.employeeTimework.getSessionCount();
  }
  /**
   * This method save session count after employee end work.
   */
  
  public void saveSessionCount() {
    this.employeeTimework.countSession();
    ConnectDatabase.saveEmployeeTimework(this);
  }
  /**
   * This method print list bill to a file.
   * @param listBill = list bill
   */
  
  public void printListBillToFile(ArrayList<Bill> listBill) {
    if (listBill.isEmpty()) {
      return;
    } else {
      String billFile = "";
      int length = listBill.size();
      for (int i = 0; i < length; i ++) {
        listBill.get(i).executed();
        ConnectDatabase.saveBill(listBill.get(i));
        billFile = billFile + listBill.get(i).convertBillToString();
      }
      try {
        File f = new File("D:\\listBill.txt");
        FileWriter fw = new FileWriter(f);
        fw.write(billFile);
        fw.close(); 
      } catch (IOException e) {
        System.out.println("Loi ghi file: " + e);
      }
    }
  }
  /**
   * This method make a bill when employee insert goods into list bill.
   * @param goods = goods
   * @param amount = amount
   * @return bill
   */
  
  public Bill creatBill(Goods goods, int amount) {
    Date date = new Date();
    return (new Bill(this, goods, amount, date));
  }
  /**
   * This method convert bill to string.
   * @param goods = goods
   * @param amount = amount
   * @return string
   */
  
  public String getBillToString(Goods goods, int amount) {
    Date date = new Date();
    return (new Bill(this,goods,amount,date)).convertBillToString();
  }
  /**
   * This method convert goods's information to string.
   * @param goods = goods
   * @return string
   */
  
  public String getInfoGoodsByString(Goods goods) {
    String newline = System.getProperty("line.separator");
    return "Name : " + goods.getName() + newline + "\nCode : " + goods.getCode() + "\nPrice : "
        + goods.getPrice() + "\nDate produce : " + goods.getDateProduce() + "\nDate expire : " 
      + goods.getDateExpire() + "\nProducer : " + goods.getProducer() + "\nAmountRemain : " 
      + goods.getAmountReamain() + "\nAmountSold : " + goods.getAmountSold();
  }
}
