package com.kichutov.app.task2;

import java.util.HashMap;
import java.util.Map;

public class Spaceship implements UObject {

  Map<String, Object> properties = new HashMap<>();

  public Spaceship() {
    properties.put("Direction", 1);
    properties.put("DirectionsNumber", 4);
    properties.put("Velocity", 1);
    properties.put("Position", new Vector(0, 0));
    properties.put("AngularVelocity", 2);
    properties.put("DirectionNumbers", 8);
  }

  @Override
  public Object getProperty(String key) {
    Object o = properties.get(key);
    return o;
  }

  @Override
  public void setProperty(String key, Object value) {
    properties.put(key, value);
  }
}
