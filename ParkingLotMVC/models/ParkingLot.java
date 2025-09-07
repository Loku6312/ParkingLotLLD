package models;

import java.util.List;
public class ParkingLot extends BaseClass{
    private String name;
    private List<Gate> entry_gates;
    private List<Gate> exit_gates;
    private ParkingLotStatus parkingLotStatus;
    private List<ParkingFloor> floors;
    private List<AllowedVehicles> allowedVehicles;
    private FeeCalculationType feeCalculationType;
    private SlotAllocationType slotAllocationType;
    public void setAllowedVehicles(List<AllowedVehicles> allowedVehicles){
        this.allowedVehicles=allowedVehicles;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setEntryGates(List<Gate> entry_gates){
        this.entry_gates=entry_gates;
    }
    public void setExitGates(List<Gate> exit_gates){
        this.exit_gates=exit_gates;
    }
    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus){
        this.parkingLotStatus=parkingLotStatus;
    }
    public void setFloors(List<ParkingFloor> floors){
        this.floors=floors;
    }
    public void setFeeCalculationType(FeeCalculationType feeCalculationType){
        this.feeCalculationType=feeCalculationType;
    }
    public void setSlotAllocationType(SlotAllocationType slotAllocationType){
        this.slotAllocationType=slotAllocationType;
    }
    public ParkingLot(String name){
        this.name=name;
    }
    public List<AllowedVehicles> getAllowedVehicles(){
        return allowedVehicles;
    }
    public String getName(){
        return name;
    }
    public List<Gate> getEntryGates(){
        return entry_gates;
    }
    public List<Gate> getExitGates(){
        return exit_gates;
    }
    public ParkingLotStatus getParkingLotStatus(){
        return parkingLotStatus;
    }
    public List<ParkingFloor> getFloors(){
        return floors;
    }
    public FeeCalculationType getFeeCalculationType(){
        return feeCalculationType;
    }
    public SlotAllocationType getSlotAllocationType(){
        return slotAllocationType;
    }

    

}
