package DTOS;

import models.VehicleType;

public class IssuTicketRequestDTO {
    private String reg_number;
    private VehicleType vehicleType;
    private String owner_name;
    private String owner_contact;
    private Long gate_id;
    public void setRegNumber(String reg_number){
        this.reg_number=reg_number;
    }
    public String getRegNumber(){
        return reg_number;
    }
    public VehicleType getVehicleType(){
        return vehicleType;
    }
    public void setVehicleType(VehicleType vehicleType){
        this.vehicleType=vehicleType;
    }
    public void setOwnerName(String owner_name){
        this.owner_name=owner_name;
    }
    public String getOwnerName(){
        return owner_name;
    }
    public void setOwnerContact(String owner_contact){
        this.owner_contact=owner_contact;
    }
    public String getOwnerContact(){
        return owner_contact;
    }
    public void setGateId(Long gateId){
        this.gate_id=gateId;
    }
    public Long getGateId(){
        return gate_id;
    }
    
}
