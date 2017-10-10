package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import model.Manager;

public class CreatNewIdController implements ActionListener {
  private Manager manager;
  private JLabel lblNewId;

  public CreatNewIdController(Manager manager, JLabel lblNewId) {
    this.manager = manager;
    this.lblNewId = lblNewId;
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    lblNewId.setText(manager.creatIdForNewEmployee());
  }

}
