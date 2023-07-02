package com.kichutov.app.task2;

public class ImmovableSpaceship extends Spaceship {

  @Override
  public void setProperty(String key, Object value) {
    if (key.equals("Position")) {
      throw new UnsupportedOperationException();
    }
    super.setProperty(key, value);
  }
}
