package model;

import java.util.Date;

public class Bill {
  private Employee employee;
  private Goods goods;
  private int amount;
  private Date date;
  /**
   * Constructor.
   * @param employee = employee
   * @param goods = goods
   * @param amount = amount
   * @param date = date
   */
  
  public Bill(Employee employee, Goods goods, int amount , Date date) {
    this.employee = employee;
    this.goods = goods;
    this.amount = amount;
    this.date = date;
  }
  
  public Goods getGoods() {
    return this.goods;
  }
  
  public int getAmount() {
    return this.amount;
  }
  
  public Employee getEmployee() {
    return employee;
  }
  
  public Date getDate() {
    return date;
  }
  
  /**
   * 
   * @return convert goods's information to string.
   */
  
  public String convertBillToString() {
    String newline = System.getProperty("line.separator");
    String bill = newline + "Sale staff :" + this.employee.getAccount().getEmployeeId() +  newline 
        + "Name : " + goods.getName() + newline + "Code : " + goods.getCode()  + newline
        + "Date Produce : " + goods.getDateProduce() + newline + "Date Expire : " 
        + goods.getDateExpire() + newline + "Producer : " + goods.getProducer() + newline
        + "Price : " + goods.getPrice()  + newline + "Amount : " + amount + newline 
        + "_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ";
    return bill;
  }
  
  public void executed() {
    this.goods.soldAmount(amount);
    ConnectDatabase.saveGoodsAfterSold(goods);
  }
}
