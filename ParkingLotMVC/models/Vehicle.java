package models;

public class Vehicle extends BaseClass{
    private String reg_number;
    private String owner_name;
    private String owner_contact;
    private VehicleType vehicleType;
    public Vehicle(String reg_number,String owner_name,String owner_contact,VehicleType vehicleType){
        this.owner_contact=owner_contact;
        this.owner_name=owner_name;
        this.vehicleType=vehicleType;
        this.reg_number=reg_number;
    }
    public String getRegNumber(){
        return reg_number;
    }
    public String getOwnerName(){
        return owner_name;
    }
    public String getOwnerContact(){
        return owner_contact;
    }
    public VehicleType getVehicleType(){
        return vehicleType;
    }
    public void setRegNumber(String reg_number){
        this.reg_number=reg_number;
    }
    public void setOwnerName(String owner_name){
        this.owner_name=owner_name;
    }
    public void setOwnerConatct(String owner_contact){
        this.owner_contact=owner_contact;
    }
    public void setVehicleType(VehicleType vehicleType){
        this.vehicleType=vehicleType;
    }
    
}
