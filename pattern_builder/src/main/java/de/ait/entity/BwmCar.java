package de.ait.entity;

/**
 * @author Andrej Reutow
 * created on 02.09.2023
 */
public class BwmCar implements Car {
    @Override
    public void drive() {
        System.out.println("i drive BMW");
    }
}
