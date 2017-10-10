package model;

public class Goods {
  private String name;
  private String code;
  private int price;
  private String dateProduce;
  private String dateExpire;
  private String producer;
  private int amountRemain;
  private int amountSold;

  public Goods() {}
  
  public String getName() {
    return this.name;
  }
  
  public String getCode() {
    return this.code;
  }
  
  public int getPrice() {
    return this.price;
  }
  
  public String getDateProduce() {
    return this.dateProduce;
  }
  
  public String getDateExpire() {
    return this.dateExpire;
  }
  
  public String getProducer() {
    return this.producer;
  }
  
  public int getAmountReamain() {
    return this.amountRemain;
  }
  
  public int getAmountSold() {
    return this.amountSold;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public void setCode(String code) {
    this.code = code;
  }
  
  public void setPrice(int price) {
    this.price = price;
  }
  
  public void setDateProduce(String date) {
    this.dateProduce = date;
  }
  
  public void setDateExpire(String date) {
    this.dateExpire = date;
  }
  
  public void setProducer(String producer) {
    this.producer = producer;
  }
  
  public void setAmountRemain(int amount) {
    this.amountRemain = amount;
  }
  
  public void setAmountSold(int amount) {
    this.amountSold = amount;
  }
  
  public void soldAmount(int amount) {
    this.amountRemain -= amount;
    this.amountSold += amount;
  }
  
  @Override
  public String toString() {
    String newline = System.getProperty("line.separator");
    return newline + "Name : " + this.name + newline + "Code : " + this.code + newline + "Price : " 
        + this.price + newline + "Date Produce : " + this.dateProduce + newline + "Date Expire : "
        + this.dateExpire + newline + "Producer : " + this.producer + newline 
        + "AmountSold : " + this.amountSold + newline + "AmountRemain : " + this.amountRemain 
        + newline + " _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ __ _ ";
  }
}
