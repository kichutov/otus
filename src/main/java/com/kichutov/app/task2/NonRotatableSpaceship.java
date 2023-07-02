package com.kichutov.app.task2;

public class NonRotatableSpaceship extends Spaceship {

  @Override
  public void setProperty(String key, Object value) {
    if (key.equals("Direction")) {
      throw new UnsupportedOperationException();
    }
    super.setProperty(key, value);
  }
}
