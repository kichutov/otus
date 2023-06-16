package com.kichutov.app;


import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.NaN;
import static java.lang.Double.POSITIVE_INFINITY;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Task1Test {

  private static final double EPSILON = 0.000001d;

  @Test
  @DisplayName("Тест, который проверяет, что для уравнения x^2+1 = 0 корней нет (возвращается пустой массив)")
  void shouldHaveZeroRoots() {
    //given
    double a = 1, b = 0, c = 1;

    //when
    double[] result = Task1.solve(a, b, c);

    //then
    Assertions.assertEquals(0, result.length);
  }

  @Test
  @DisplayName("Тест, который проверяет, что для уравнения x^2-1 = 0 есть два корня кратности 1 (x1=1, x2=-1)")
  void shouldHaveTwoRoots() {
    //given
    double a = 1, b = 0, c = -1;

    //when
    double[] result = Task1.solve(a, b, c);

    //then
    Assertions.assertEquals(2, result.length);
    Assertions.assertTrue(result[0] == -result[1]);
  }

  @Test // Дискриминант не ноль, но меньше заданного epsilon
  @DisplayName("Тест, который проверяет, что для уравнения x^2+2x+1 = 0 есть один корень кратности 2 (x1= x2 = -1)")
  void shouldHaveOneRoot() {
    //given
    double a = 1, b = 2, c = 0.999999999999999;

    //when
    double[] result = Task1.solve(a, b, c);

    //then
    Assertions.assertEquals(2, result.length);
    Assertions.assertTrue(Math.abs(result[0] - result[1]) < EPSILON);
  }

  @Test
  @DisplayName("Тест, который проверяет, что коэффициент a не может быть равен 0")
  void shouldThrowException() {
    //given
    double a = 0, b = 2, c = 1;

    //when

    //then
    Assertions.assertThrows(IllegalArgumentException.class, () -> Task1.solve(a, b, c));
  }

  @ParameterizedTest
  @ValueSource(doubles = {NaN, NEGATIVE_INFINITY, POSITIVE_INFINITY})
  @DisplayName("Тест, который проверяет, некорректные значения double (пункт 13)")
  void shouldThrowExceptions(double x) {
    //given
    //when
    //then
    Assertions.assertThrows(IllegalArgumentException.class, () -> Task1.solve(x, 2, 1));
    Assertions.assertThrows(IllegalArgumentException.class, () -> Task1.solve(1, x, 1));
    Assertions.assertThrows(IllegalArgumentException.class, () -> Task1.solve(1, 2, x));
  }
}
