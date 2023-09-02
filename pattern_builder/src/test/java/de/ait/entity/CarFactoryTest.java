package de.ait.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Andrej Reutow
 * created on 02.09.2023
 */
class CarFactoryTest {

    private CarFactory carFactory = new CarFactory();

    @Test
    void test_createCatFactory_BmwCarCreated() {
        Car car = carFactory.getCar(CarEnum.BWM);
        car.drive();

        assertTrue(car instanceof BwmCar, "created car is: " + car.getClass().getName());
    }

    @Test
    void test_createCatFactory_VWCarCreated() {
        Car car = carFactory.getCar(CarEnum.VW);
        car.drive();

        assertTrue(car instanceof VwCar, "created car is: " + car.getClass().getName());
    }

    @Test
    void test_createCatFactory_MercedesCarCreated() {
        Car car = carFactory.getCar(CarEnum.MERCEDES);
        car.drive();

        assertTrue(car instanceof MercedesCar, "created car is: " + car.getClass().getName());
    }
}
