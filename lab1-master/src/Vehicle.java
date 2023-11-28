package src;

import java.awt.*;

public abstract class Vehicle implements Movable {
    private final String[] directions = {"N", "E", "S", "W"};
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected String modelName; // The car model name
    private int direction; // The direction that the car is facing
    private double currentSpeed; // The current speed of the car must be public
    private Color color; // Color of the car
    private double xCoordinate; // The x coordinate of the car
    private double yCoordinate; // The Y coordinate of the car

    public Vehicle(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.modelName = modelName;
        setColor(color);
        setDirection(0);
        setXCoordinate(0);
        setYCoordinate(0);
        stopEngine();
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public String getDirection() {
        return directions[direction];
    }

    public double getXCoordinate() {
        return xCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }

    public String getModelName() {
        return modelName;
    }

    public void startEngine() {
        setCurrentSpeed(0.1);
    }

    public void stopEngine() {
        setCurrentSpeed(0);
    }

    @Override
    public void move() {

        double speed = getCurrentSpeed();
        String currentDirection = getDirection();
        switch (currentDirection) {
            case "N" -> setYCoordinate(getYCoordinate() + speed);
            case "S" -> setYCoordinate(getYCoordinate() - speed);
            case "E" -> setXCoordinate(getXCoordinate() + speed);
            case "W" -> setXCoordinate(getXCoordinate() - speed);
        }
    }

    @Override
    public void turnLeft() {
        setDirection((direction + 1) % 4);
    }

    @Override
    public void turnRight() {
        setDirection((direction + 3) % 4);
    }

    public void incrementSpeed(double amount) {
        double newSpeed = Math.min(getCurrentSpeed() + calculateSpeedFactor() * amount, getEnginePower());
        if (newSpeed > getCurrentSpeed()) {
            setCurrentSpeed(newSpeed);
        }
    }

    public void decrementSpeed(double amount) {
        double newSpeed = Math.max(getCurrentSpeed() - calculateSpeedFactor() * amount, 0);
        if (newSpeed <= getCurrentSpeed()) {
            setCurrentSpeed(newSpeed);
        }
    }

    protected abstract double calculateSpeedFactor();

    public void gas(double amount) {
        if (amount > 0 && amount < 1) {
            incrementSpeed(amount);
        }
    }

    public void brake(double amount) {
        if (amount > 0 && amount < 1) {
            decrementSpeed(amount);
        }
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public void setXCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setYCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}
