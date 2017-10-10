package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.RegisterView;

public class MoveToRegisterView implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    new RegisterView();
  }
}
