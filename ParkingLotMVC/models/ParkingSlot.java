package models;

import java.util.List;

public class ParkingSlot {
    private String number;
    private ParkingSlotStatus parkingSlotStatus;
    private List<AllowedVehicles> allowedvehicles;
    public ParkingSlot(String number,ParkingSlotStatus parkingSlotStatus,List<AllowedVehicles> allowedVehicles){
        this.number=number;
        this.parkingSlotStatus=parkingSlotStatus;
        this.allowedvehicles=allowedVehicles;
    }
    public void setNumber(String number){
        this.number=number;
    }
    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus){
        this.parkingSlotStatus=parkingSlotStatus;
    }
    public void setAllowedVehicles(List<AllowedVehicles> allowedVehicles){
        this.allowedvehicles=allowedVehicles;
    }
    public String getNumber(){
        return number;
    }
    public ParkingSlotStatus geParkingSlotStatus(){
        return parkingSlotStatus;
    }
    public List<AllowedVehicles> getAllowedVehicles(){
        return allowedvehicles;
    }
}
