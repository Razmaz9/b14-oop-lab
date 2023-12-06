package src;
import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Vehicle implements Movable {
    public Point2D.Double position = new Point2D.Double();
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected String modelName; // The car model name
    private Direction direction; // The direction that the car is facing
    private double currentSpeed; // The current speed of the car must be public
    private Color color; // Color of the car
    private double xCoordinate; // The x coordinate of the car
    private double yCoordinate; // The Y coordinate of the car

    protected Vehicle(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.modelName = modelName;
        setColor(color);
        setDirection(Direction.NORTH);
        setPosition(0, 0);
        stopEngine();
    }

    private void setPosition(int x, int y) {
        this.position.x = x;
        this.position.y = y;
    }

    public Point2D.Double getPosition() {
        return position;
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

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public double getXCoordinate() {
        return getPosition().x;
    }

    public void setXCoordinate(double xCoordinate) {
        this.position.x = xCoordinate;
    }

    public double getYCoordinate() {
        return getPosition().y;
    }

    public void setYCoordinate(double yCoordinate) {
        this.position.y = yCoordinate;
    }

    public String getModelName() {
        return modelName;
    }

    public void startEngine() {
        gas(0.1);
    }

    public void stopEngine() {
        setCurrentSpeed(0);
    }

    @Override
    public void move() {

        double speed = getCurrentSpeed();
        switch (direction) {
            case NORTH -> setYCoordinate(getYCoordinate() + speed);
            case SOUTH -> setYCoordinate(getYCoordinate() - speed);
            case EAST -> setXCoordinate(getXCoordinate() + speed);
            case WEST -> setXCoordinate(getXCoordinate() - speed);
        }
    }

    @Override
    public void turnLeft() {
        setDirection(direction.getPrevious());
    }

    @Override
    public void turnRight() {
        setDirection(direction.getNext());
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
}
