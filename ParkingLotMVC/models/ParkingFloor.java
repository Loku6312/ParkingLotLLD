package models;

import java.util.List;

public class ParkingFloor extends BaseClass{
    private Integer floorNo;
    private List<ParkingSlot> parkingslots;
    private ParkingFloorStatus floorStatus;
    private List<AllowedVehicles> allowedVehicles;
    /*public ParkingFloor(Integer floorNo,List<ParkingSlot> parkingSlots,ParkingFloorStatus floorStatus,List<AllowedVehicles> allowedVehicles){
        this.floorNo=floorNo;
        this.parkingslots=parkingSlots;
        this.floorStatus=floorStatus;
        this.allowedVehicles=allowedVehicles;
    }*/
    public Integer getFloorNo(){
        return floorNo;
    }
    public List<ParkingSlot> getParkingSlots(){
        return parkingslots;
    }
    public ParkingFloorStatus getFloorStatus( ){
        return floorStatus;
    }
    public List<AllowedVehicles>  getAllowedVehicles(){
        return allowedVehicles;
    }
    public void setFloorNo(Integer floorNo){
        this.floorNo=floorNo;
    }
    public void setParkingSlots(List<ParkingSlot> parkingslots){
        this.parkingslots=parkingslots;
    }
    public void setFloorStatus(ParkingFloorStatus parkingFloorStatus){
        this.floorStatus=parkingFloorStatus;
    }
    public void setAllowedVehicles(List<AllowedVehicles> allowedVehicles){
        this.allowedVehicles=allowedVehicles;
    }


    

}
