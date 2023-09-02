package de.ait.entity;

/**
 * @author Andrej Reutow
 * created on 02.09.2023
 */
public class CarFactory {

    public Car getCar(CarEnum carEnum) {
        Car car = null;

        switch (carEnum) {
            case BWM -> car = new BwmCar();
            case VW -> car = new VwCar();
            case MERCEDES -> car = new MercedesCar();
        }

        return car;
    }
}
