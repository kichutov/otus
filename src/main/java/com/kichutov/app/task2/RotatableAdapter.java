package com.kichutov.app.task2;

public class RotatableAdapter implements Rotatable {

  UObject uObject;

  public RotatableAdapter(UObject uObject) {
    this.uObject = uObject;
  }


  @Override
  public int getAngularVelocity() {
    return (int) uObject.getProperty("AngularVelocity");
  }

  @Override
  public int getDirectionNumbers() {
    return (int) uObject.getProperty("DirectionNumbers");
  }

  @Override
  public int getDirection() {
    return (int) uObject.getProperty("Direction");
  }

  @Override
  public void setDirection(int direction) {
    uObject.setProperty("Direction", direction);
  }
}
