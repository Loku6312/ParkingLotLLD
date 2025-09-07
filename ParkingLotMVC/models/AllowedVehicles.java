package models;
public class AllowedVehicles extends BaseClass{
    private VehicleType vehicleType;
    private int capacity;
    public AllowedVehicles(VehicleType vehicleType,int capacity){
        this.vehicleType=vehicleType;
        this.capacity=capacity;
    }
    public void setCapacity(int capacity){
        this.capacity=capacity;
    }
    public int getCapacity(){
        return capacity;
    }
    public void setVehicleType(VehicleType vehicleType){
        this.vehicleType=vehicleType;
    }
    public VehicleType getVehicleType(){
        return vehicleType;
    }
    
}
