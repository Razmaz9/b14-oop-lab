package src;

import org.junit.Test;
import org.junit.Assert;
import java.awt.Color;
import static org.junit.Assert.*;

public class TestsCar {

    public Saab95 Saab = new Saab95();
    public Volvo240 Volvo = new Volvo240();
    public Scania Scania = new Scania();
    public Workshop Workshop = new Workshop();

    public CarTransport CarTransport = new CarTransport();


    @Test
    public void nrOfDoors() {
        Assert.assertEquals("GetNrOfDoors should work", Saab.getNrDoors(), 2);
    }

    @Test
    public void getDirection() {
        Assert.assertEquals("Get direction works", Saab.getDirection(), "N");
    }

    @Test
    public void speedFactor(){

    }

    @Test
    public void turningLeft() {
        Saab.turnLeft();
        Assert.assertEquals("Turning left works", Saab.getDirection(), "E");
    }

    @Test
    public void rotatingLeftToNorth() {
        Saab.turnLeft();
        Saab.turnLeft();
        Saab.turnLeft();
        Saab.turnLeft();
        Assert.assertEquals("Rotating left works", Saab.getDirection(), "N");
    }

    @Test
    public void turningRight() {
        Saab.turnRight();
        Assert.assertEquals("Turning right works", Saab.getDirection(), "W");
    }

    @Test
    public void rotatingRight() {
        Saab.turnRight();
        Saab.turnRight();
        Saab.turnRight();
        Saab.turnRight();
        Assert.assertEquals("Rotating right works", Saab.getDirection(), "N");
    }

    @Test
    public void startingEngine() {
        Saab.startEngine();
        assertEquals("Engine moves the car forward slowly", Saab.getCurrentSpeed(), 0.1, 3);
    }

    @Test
    public void stopEngine() {
        Saab.stopEngine();
        assertEquals("Engine stop the car and any movement", Saab.getCurrentSpeed(), 0.0, 3);

    }

    @Test
    public void getXCoordinate() {
        assertEquals("Get x coordinate works", Saab.getXCoordinate(), 0, 3);
    }

    @Test
    public void getYCoordinate() {
        assertEquals("Get y coordinate works", Saab.getYCoordinate(), 0, 3);
    }

    @Test
    public void getColour() {
        assertEquals("Get colour works", Saab.getColor(), Color.red);
    }

    @Test
    public void changeColour() {
        Saab.setColor(Color.blue);
        assertEquals("You can change colour", Saab.getColor(), Color.blue);
    }

    @Test
    public void getEnginePower() {
        assertEquals("GetEnginePower works", Saab.getEnginePower(), 125, 3);
    }

    @Test
    public void gasWithTurboSaab() {
        Saab.startEngine();
        Saab.setTurboOn();
        Saab.gas(0.5);
        assertEquals("Gas works with turbo", Saab.getCurrentSpeed(), 0.9125, 5);
    }

    @Test
    public void gasWithTurboOffSaab() {
        Saab.startEngine();
        Saab.gas(0.5);
        assertEquals("Gas works without turbo", Saab.getCurrentSpeed(), 0.725, 5);
    }

    @Test
    public void drivingForward() {
        Saab.startEngine();
        Saab.gas(0.5);
        Saab.move();
        assertEquals("Driving forward works", Saab.getYCoordinate(), 0.725, 5);
    }

    @Test
    public void drivingBackwards() {
        Saab.startEngine();
        Saab.gas(0.5);
        Saab.turnLeft();
        Saab.turnLeft();
        Saab.move();
        assertEquals("Driving backwords works", Saab.getYCoordinate(), -0.725, 5);
    }

    @Test
    public void drivingToTheRight() {
        Saab.startEngine();
        Saab.gas(0.5);
        Saab.turnRight();
        Saab.move();
        assertEquals("Driving right works", Saab.getXCoordinate(), 0.725, 5);
    }

    @Test
    public void drivingToTheLeft() {
        Saab.startEngine();
        Saab.gas(0.5);
        Saab.turnLeft();
        Saab.move();
        assertEquals("Driving left works", Saab.getXCoordinate(), -0.725, 5);
    }

    @Test
    public void brakingWithoutTurboSaab() {
        Saab.startEngine();
        Saab.gas(0.5);
        Saab.brake(0.5);
        assertEquals("Braking works", Saab.getCurrentSpeed(), 0, 5);
    }

    @Test
    public void brakingWithTurboSaab() {
        Saab.startEngine();
        Saab.setTurboOn();
        Saab.gas(0.5);
        Saab.brake(0.5);
        assertEquals("Breaking works with turbo", Saab.getCurrentSpeed(), 0, 5);
    }

    @Test
    public void turningOffTheEngine() {
        Saab.startEngine();
        Saab.stopEngine();
        assertEquals("Turning off the engine works", Saab.getCurrentSpeed(), 0, 5);
    }

    @Test
    public void turningOffTheTurboSaab() {
        Saab.setTurboOn();
        Saab.setTurboOff();
        Saab.gas(0.5);
        assertEquals("Turning off the turbo works", Saab.getCurrentSpeed(), 0.725, 5);
    }

    @Test
    public void gasVolvo() {
        Volvo.startEngine();
        Volvo.gas(0.5);
        assertEquals("Gas works without turbo", Volvo.getCurrentSpeed(), 0.725, 5);
    }

    @Test
    public void brakingVolvo() {
        Volvo.startEngine();
        Volvo.gas(0.5);
        Volvo.brake(0.5);
        assertEquals("Braking works", Volvo.getCurrentSpeed(), 0, 5);
    }

    @Test
    public void getModelName(){
        assertEquals("Get model name works", Volvo.getModelName(),"Volvo240");
    }



}