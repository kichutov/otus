package com.kichutov.app.task2;

public class MovableAdapter implements Movable {

  UObject uObject;

  public MovableAdapter(UObject uObject) {
    this.uObject = uObject;
  }

  @Override
  public Vector getVelocity() {
    int d = (int) uObject.getProperty("Direction");
    int n = (int) uObject.getProperty("DirectionsNumber");
    int v = (int) uObject.getProperty("Velocity");
    return new Vector(
        (int) Math.round(v*Math.cos((double)d/360*n)),
        (int) Math.round(v*Math.sin((double)d/360*n))
    );
  }

  @Override
  public Vector getPosition() {
    Object position = uObject.getProperty("Position");
    return (Vector) position;
  }

  @Override
  public void setPosition(Vector vector) {
    uObject.setProperty("Position", vector);
  }
}
