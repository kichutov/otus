package com.kichutov.app.task2;

public class Vector {

  final int x;
  final int y;

  public Vector(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public static Vector Plus(Vector position, Vector velocity) {
    int newX = position.x + velocity.x;
    int newY = position.y + velocity.y;
    return new Vector(newX, newY);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Vector vector = (Vector) o;

    if (x != vector.x) {
      return false;
    }
    return y == vector.y;
  }

  @Override
  public int hashCode() {
    int result = x;
    result = 31 * result + y;
    return result;
  }

}
