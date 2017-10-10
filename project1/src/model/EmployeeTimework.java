package model;

import java.util.Date;

public class EmployeeTimework {
  private Date timeBegin;
  private Date timeEnd;
  private int timePerSession;
  private int sessionCount;

  public EmployeeTimework() {}

  public void setTimePerSession(int t) {
    this.timePerSession = t;
  }
  
  public void beginWork() {
    this.timeBegin = new Date();
  }
  
  public void endWork() {
    this.timeEnd = new Date();
  }
  
  public void  countSession() {
    this.sessionCount +=  (int)((timeEnd.getTime() - timeBegin.getTime()) 
          / (timePerSession * 3600));
  }
  
  public int getTimework() {
    return (int)(timeEnd.getTime() - timeBegin.getTime()) / (timePerSession * 3600);
  }
  
  public int getSessionCount() {
    return this.sessionCount;
  }
  
  public void resetSessionCount() {
    this.sessionCount = 0;
  }
  
  public void setSessionCount(int count) {
    this.sessionCount = count;
  }
}
