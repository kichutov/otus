package com.kichutov.app.task2;

public class Rotate {

  Rotatable rotatable;

  public Rotate(Rotatable rotatable) {
    this.rotatable = rotatable;
  }

  public void execute() {
    int newDirection = (rotatable.getDirection() + rotatable.getAngularVelocity()) % rotatable.getDirectionNumbers();
    rotatable.setDirection(newDirection);
  }

}
