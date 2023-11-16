package src;

public class WorkshopSaab extends Workshop<Saab95> {

    public WorkshopSaab(){
        setSpecializedWorkshop(true);
        setVehicleLimit(8);
    }
}
