package model;

import java.util.Date;

public class MyDate {
  /**
   *This method convert long time t to date.
   */
  
  @SuppressWarnings("deprecation")
  public static String toDate(long t) {
    Date date = new Date(t);
    String txtDate = "";
    String txtMonth = "";
    if (date.getDate() < 10) {
      txtDate = "0" + date.getDate();
    } else {
      txtDate = "" + date.getDate();
    }
    if (date.getMonth() < 9) {
      txtMonth = "-0" + (date.getMonth() + 1);
    } else {
      txtMonth = "-" + (date.getMonth() + 1);
    }
    return txtDate + txtMonth + "-" + (date.getYear() + 1900);
  }
}
