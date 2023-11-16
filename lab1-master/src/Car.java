package src;

import java.awt.*;
public abstract class Car implements Movable {
        private final String[] directions = {"N", "E", "S", "W"};
        public int nrDoors; // Number of doors on the car
        public double enginePower; // Engine power of the car
        private double currentSpeed; // The current speed of the car must be public
        public Color color; // Color of the car
        public String modelName; // The car model name
        public int direction; // The direction that the car is facing
        public double xCoordinate; // The x coordinate of the car
        public double yCoordinate; // The Y coordinate of the car
        public int getNrDoors(){
            return nrDoors;
        }
        public double getEnginePower(){
            return enginePower;
        }
        public double getCurrentSpeed(){
            return currentSpeed;
        }
        public Color getColor(){
            return color;
        }
        public String getDirection() {
            return directions[direction];
        }
        public double getxCoordinate(){
            return xCoordinate;
        }
        public double getyCoordinate(){
            return yCoordinate;
        }
        public void setColor(Color clr){
            color = clr;
        }
        public void startEngine(){
            currentSpeed = 0.1;
        }
        public void stopEngine(){
            currentSpeed = 0;
        }

        @Override
        public void move() {

            double speed = getCurrentSpeed();
            String currentDirection = getDirection();
            if (currentDirection.equals("N")){
                yCoordinate = getyCoordinate() + speed;
            }
            else if (currentDirection.equals("S")){
                yCoordinate = getyCoordinate() - speed;
            }
            else if (currentDirection.equals("E")){
                xCoordinate = getxCoordinate() + speed;
            }
            else if (currentDirection.equals("W")){
                xCoordinate = getxCoordinate() - speed;
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
        public double speedFactor(){
            return enginePower * 0.01;
        }
        public void incrementSpeed(double amount){
            double newSpeed  = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
            if (newSpeed > getCurrentSpeed()) {
                currentSpeed = newSpeed;
            }
        }
        public void decrementSpeed(double amount){
            double newSpeed  = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
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
}
