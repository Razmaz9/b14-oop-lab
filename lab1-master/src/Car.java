package src;

import java.awt.*;

public abstract class Car implements Movable {
    private final String[] directions = {"N", "E", "S", "W"};
    private int direction; // The direction that the car is facing
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double speedFactor;
    private double currentSpeed; // The current speed of the car must be public
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double xCoordinate; // The x coordinate of the car
    private double yCoordinate; // The Y coordinate of the car
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
                case "N" -> yCoordinate = getYCoordinate() + speed;
                case "S" -> yCoordinate = getYCoordinate() - speed;
                case "E" -> xCoordinate = getXCoordinate() + speed;
                case "W" -> xCoordinate = getXCoordinate() - speed;
            }
        }
        @Override
        public void turnLeft() {
            direction = (direction + 1) % 4;
        }
        @Override
        public void turnRight() {
            direction = (direction + 3 ) % 4;
        }

        public void incrementSpeed(double amount){
            double newSpeed  = Math.min(getCurrentSpeed() + speedFactor * amount,enginePower);
            if (newSpeed > getCurrentSpeed()) {
                currentSpeed = newSpeed;
            }
        }
        public void decrementSpeed(double amount){
            double newSpeed  = Math.max(getCurrentSpeed() - speedFactor * amount,0);
            if (newSpeed <= getCurrentSpeed()) {
                currentSpeed = newSpeed;
            }
        }

        public void gas(double amount){
            if (amount > 0 && amount < 1){
                incrementSpeed(amount);
            }
        }
        public void brake(double amount){
            if (amount > 0 && amount < 1){
                decrementSpeed(amount);
            }
        }

    public double getSpeedFactor() {
        return speedFactor;
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
