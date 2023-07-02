package com.kichutov.app.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class Task2Test {

  /**
   * Тесты на движение
   */
  @Test
  @DisplayName("Для объекта, находящегося в точке (12, 5) и движущегося со скоростью (-7, 3) движение меняет положение объекта на (5, 8)")
  void shouldMoveCorrectly() {
    //given
    Movable movable = new MovableAdapter(new Spaceship());
    movable.setPosition(new Vector(12, 5));
    Movable spyMovable = Mockito.spy(movable);

    //when
    Mockito.when(spyMovable.getVelocity()).thenReturn(new Vector(-7, 3));
    Move move = new Move(spyMovable);
    move.execute();

    //then
    Assertions.assertEquals(new Vector(5, 8), spyMovable.getPosition());
  }

  @Test
  @DisplayName("Попытка сдвинуть объект, у которого невозможно прочитать положение в пространстве, приводит к ошибке")
  void shouldThrowExceptionBecausePositionCouldNotBeRead() {
    //given
    Movable movable = new MovableAdapter(new Spaceship());
    Movable spyMovable = Mockito.spy(movable);

    //when
    Mockito.when(spyMovable.getPosition()).thenReturn(null);

    //then
    Move move = new Move(spyMovable);
    Assertions.assertThrows(NullPointerException.class, move::execute);
  }

  @Test
  @DisplayName("Попытка сдвинуть объект, у которого невозможно прочитать значение мгновенной скорости, приводит к ошибке")
  void shouldThrowExceptionBecauseVelocityCouldNotBeRead() {
    //given
    Movable movable = new MovableAdapter(new Spaceship());
    Movable spyMovable = Mockito.spy(movable);

    //when
    Mockito.when(spyMovable.getVelocity()).thenReturn(null);

    //then
    Move move = new Move(spyMovable);
    Assertions.assertThrows(NullPointerException.class, move::execute);
  }

  @Test
  @DisplayName("Попытка сдвинуть объект, у которого невозможно изменить положение в пространстве, приводит к ошибке")
  void shouldThrowExceptionBecauseSpaceshipIsImmovable() {
    //given
    Movable movable = new MovableAdapter(new ImmovableSpaceship());
    Move move = new Move(movable);

    //then
    Assertions.assertThrows(UnsupportedOperationException.class, move::execute);
  }


  /**
   * Тесты на поворот
   */
  @Test
  @DisplayName("Для объекта, с направлением 2 и скоростью вращения 3 направление объекта изменяется на 5")
  void shouldRotateCorrectly() {
    //given
    Rotatable rotatable = new RotatableAdapter(new Spaceship());
    rotatable.setDirection(3);

    //when
    Rotate rotate = new Rotate(rotatable);
    rotate.execute();

    //then
    Assertions.assertEquals(5, rotatable.getDirection());
  }

  @Test
  @DisplayName("Попытка повернуть объект, у которого невозможно прочитать направление, приводит к ошибке")
  void shouldThrowExceptionBecauseDirectionCouldNotBeRead() {
    //given
    Rotatable rotatable = new RotatableAdapter(new Spaceship());
    Rotatable spyRotatable = Mockito.spy(rotatable);

    //when
    Mockito.when(spyRotatable.getDirection()).thenThrow(new RuntimeException());

    //then
    Rotate rotate = new Rotate(spyRotatable);
    Assertions.assertThrows(RuntimeException.class, rotate::execute);
  }

  @Test
  @DisplayName("Попытка повернуть объект, у которого невозможно прочитать скорость вращения, приводит к ошибке")
  void shouldThrowExceptionBecauseAngularVelocityCouldNotBeRead() {
    //given
    Rotatable rotatable = new RotatableAdapter(new Spaceship());
    Rotatable spyRotatable = Mockito.spy(rotatable);

    //when
    Mockito.when(spyRotatable.getDirection()).thenThrow(new RuntimeException());

    //then
    Rotate rotate = new Rotate(spyRotatable);
    Assertions.assertThrows(RuntimeException.class, rotate::execute);
  }

  @Test
  @DisplayName("Попытка повернуть объект, у которого невозможно прочитать число направлений, приводит к ошибке")
  void shouldThrowExceptionBecauseDirectionNumbersCouldNotBeRead() {
    //given
    Rotatable rotatable = new RotatableAdapter(new Spaceship());
    Rotatable spyRotatable = Mockito.spy(rotatable);

    //when
    Mockito.when(spyRotatable.getDirectionNumbers()).thenThrow(new RuntimeException());

    //then
    Rotate rotate = new Rotate(spyRotatable);
    Assertions.assertThrows(RuntimeException.class, rotate::execute);
  }

  @Test
  @DisplayName("Попытка повернуть объект, у которого невозможно изменить направление, приводит к ошибке")
  void shouldThrowExceptionBecauseSpaceshipIsNonRotatable() {
    //given
    Rotatable rotatable = new RotatableAdapter(new NonRotatableSpaceship());
    Rotate rotate = new Rotate(rotatable);

    //then
    Assertions.assertThrows(UnsupportedOperationException.class, rotate::execute);
  }
}
