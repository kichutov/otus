package com.kichutov.app;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.NaN;
import static java.lang.Double.POSITIVE_INFINITY;

import java.util.Set;

public class Task1 {

  private static final double EPSILON = 0.000001d;
  private static final Set<Double> INVALID_VALUES = Set.of(NaN, NEGATIVE_INFINITY, POSITIVE_INFINITY);

  public static double[] solve(double a, double b, double c) {
    if (INVALID_VALUES.contains(a) || INVALID_VALUES.contains(b) || INVALID_VALUES.contains(c)) {
      throw new IllegalArgumentException("Invalid arguments were passed to the method");
    }
    if (Math.abs(a) < EPSILON) {
      throw new IllegalArgumentException("The coefficient 'a' cannot be equal to 0");
    }

    double D = b * b - 4 * a * c;

    if (D > 0) {
      return new double[]{(-b - Math.sqrt(D)) / (2 * a), (-b + Math.sqrt(D)) / (2 * a)};
    } else if (Math.abs(D) < EPSILON) {
      return new double[]{-b / (2 * a), -b / (2 * a)};
    } else {
      return new double[]{};
    }
  }

}

