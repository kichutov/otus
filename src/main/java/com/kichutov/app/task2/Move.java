package com.kichutov.app.task2;

public class Move {

  Movable movable;

  public Move(Movable movable) {
    this.movable = movable;
  }

  public void execute() {
    Vector position = movable.getPosition();
    Vector velocity = movable.getVelocity();
    movable.setPosition(Vector.Plus(position, velocity));
  }

}
