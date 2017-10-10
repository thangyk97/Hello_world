package main;

import java.awt.EventQueue;
import model.ConnectDatabase;
import view.LoginView;

public class Main {
  
  /**
   * 
   * @param args the command line parameter.
   * @throws Exception .
   */
  
  public static void main(String[] args) throws Exception {
    ConnectDatabase con = new ConnectDatabase();
    con.createTable("bill_tb");
    con.createTable("account_tb");
    con.createTable("employeeinfo_tb");
    con.createTable("goods_tb");
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          new LoginView();
         
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

}
