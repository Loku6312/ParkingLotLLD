package ParkingLot.Entities;

import java.util.Date;
import java.util.UUID;

import ParkingLot.Vehicle.Vehicle;

public class ParkingTicket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final long entryTimeStamp;
    private long exitTimeStamp;
    public ParkingTicket(Vehicle vehicle,ParkingSpot spot){
        this.ticketId=UUID.randomUUID().toString();
        this.vehicle=vehicle;
        this.spot=spot;
        this.entryTimeStamp=new Date().getTime();
    }
    public String getTicket(){
        return ticketId;
    }
    public Vehicle getVehicle(){
        return vehicle;
    }
    public ParkingSpot getSpot(){
        return spot;
    }
    public long getEntryTimeStamp(){
        return entryTimeStamp;
    }
    public long getExitTimeStamp(){
        return exitTimeStamp;
    }
    public void setExitTimeStamp(){
        this.exitTimeStamp=new Date().getTime();
    }

    
    
}
