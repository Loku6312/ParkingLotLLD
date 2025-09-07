package models;

import java.util.Date;

public class Ticket {
    private String number;
    private ParkingSlot parkingSlot;
    private Date entry_Time;
    private Vehicle vehicle;
    private Gate gate;
    private Operator operator;
    public void setNumber(String number){
        this.number=number;
    }
    public String getNumber(){
        return number;
    }
    public void setParkingSlot(ParkingSlot parkingslot){
        this.parkingSlot=parkingslot;
    }
    public ParkingSlot getParkingSlot(){
        return parkingSlot;
    }
    public void setEntryTime(Date entry_Time){
        this.entry_Time=entry_Time;
    }
    public Date getEntryTime(){
        return entry_Time;
    }
    public void setVehicle(Vehicle vehicle){
        this.vehicle=vehicle;
    }
    public Vehicle getVehicle(){
        return vehicle;
    }
    public void setGate(Gate gate){
        this.gate=gate;
    }
    public Gate getGate(){
        return gate;
    }
    public void setOperator(Operator operator){
        this.operator=operator;
    }
    public Operator getOperator(){
        return operator;
    }

    
    
}
