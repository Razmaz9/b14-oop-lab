package src;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class Tests {

    public Saab95 Saab = new Saab95();
    public Saab95 Saab2 = new Saab95();
    public Volvo240 Volvo = new Volvo240();
    public Volvo240 Volvo2 = new Volvo240();
    public Volvo240 Volvo3 = new Volvo240();


    public Scania Scania = new Scania();

    public Workshop<StorableCar> Workshop = new Workshop<>();
    public Workshop<Volvo240> VolvoWorkshop = new Workshop<>();
    public Workshop<Saab95> SaabWorkshop = new Workshop<>();

    public CarTransport CarTransport = new CarTransport();


    @Test
    public void nrOfDoors() {
        Assert.assertEquals("GetNrOfDoors should work", Saab.getNrDoors(), 2);
    }

    @Test
    public void getDirection() {
        Assert.assertEquals("Get direction works", Saab.getDirection(), Direction.NORTH);
    }


    @Test
    public void turningLeft() {
        Saab.turnLeft();
        Assert.assertEquals("Turning left works", Saab.getDirection(), Direction.WEST);
    }

    @Test
    public void rotatingLeftToNorth() {
        Saab.turnLeft();
        Saab.turnLeft();
        Saab.turnLeft();
        Saab.turnLeft();
        Assert.assertEquals("Rotating left works", Saab.getDirection(), Direction.NORTH);
    }

    @Test
    public void turningRight() {
        Saab.turnRight();
        Assert.assertEquals("Turning right works", Saab.getDirection(), Direction.EAST);
    }

    @Test
    public void rotatingRight() {
        Saab.turnRight();
        Saab.turnRight();
        Saab.turnRight();
        Saab.turnRight();
        Assert.assertEquals("Rotating right works", Saab.getDirection(), Direction.NORTH);
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
    public void getModelName() {
        assertEquals("Get model name works", Volvo.getModelName(), "Volvo240");
    }


    @Test
    public void setPlatformAngle() {
        Scania.setPlatformAngle(-30);
        assertEquals("Set platform angle works", Scania.getPlatformAngle(), 0);
    }

    @Test
    public void setPlatformAngleWhenMoving() {
        Scania.startEngine();
        Scania.gas(0.5);
        Scania.setPlatformAngle(10);
        assertEquals("Cant set platform angle restriction when moving works", Scania.getPlatformAngle(), 0);
    }

    @Test
    public void moveWhenPlatformDown() {
        Scania.setPlatformAngle(20);
        Scania.startEngine();
        Scania.move();
        assertEquals("Cant move when platform is lowered restriction works", Scania.getYCoordinate(), 0, 5);
    }

    @Test
    public void storeVehicleToTransport() {
        CarTransport.storeItem(Volvo);
        assertEquals("Storing vehicle works for car transport", CarTransport.getStorage().get(0), Volvo);
    }

    @Test
    public void removeVehicleFromTransport() {
        CarTransport.storeItem(Volvo);
        CarTransport.storeItem(Volvo2);
        CarTransport.removeLastItem();
        CarTransport.storeItem(Volvo3);
        assertEquals("Removing vehicle works for car transport", CarTransport.getStorage().get(1), Volvo3);
    }

    @Test
    public void openCarTransportPlatform() {
        CarTransport.openPlatform();
        assertTrue("Set platform angle works for car transport", CarTransport.isPlatformOpen());
    }

    @Test
    public void closeCarTransportPlatform() {
        CarTransport.closePlatform();
        assertFalse("Set platform angle works for car transport", CarTransport.isPlatformOpen());
    }

    @Test
    public void carMovesWithTransport() {
        CarTransport.storeItem(Volvo);
        CarTransport.closePlatform();
        CarTransport.startEngine();
        CarTransport.gas(0.5);
        CarTransport.move();
        assertEquals("Car moving with car transport works", CarTransport.getXCoordinate(), Volvo.getXCoordinate(), 5);

    }

    @Test
    public void checkIfLoadable() {
        Volvo.setXCoordinate(10);
        CarTransport.storeItem(Volvo);
        CarTransport.storeItem(Saab);
        assertEquals("Only cars close enough can be loaded for car transport works", CarTransport.getStorage().get(0), Saab);
    }

    @Test
    public void volvoWorkshop() {
        VolvoWorkshop.storeItem(Volvo2);
        VolvoWorkshop.removeItem(Volvo2);
        VolvoWorkshop.storeItem(Volvo);
        assertEquals("Volvo workshop works", VolvoWorkshop.storage.get(0), Volvo);
    }

    @Test
    public void saabWorkshop() {
        SaabWorkshop.storeItem(Saab);
        SaabWorkshop.removeItem(Saab);
        SaabWorkshop.storeItem(Saab2);
        assertEquals("Saab workshop works", SaabWorkshop.storage.get(0), Saab2);
    }

    @Test
    public void workshop() {
        Workshop.storeItem(Saab);
        Workshop.storeItem(Volvo);
        Workshop.removeItem(Saab);
        assertEquals("Workshop works", Workshop.storage.get(0), Volvo);
    }

    @Test
    public void workshopSetMaxStorage() {
        Workshop.setMaxStorage(1);
        assertEquals("Set max storage for workshop works", Workshop.getMaxStorage(), 1);
    }


}