package ParkingLot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import ParkingLot.Entities.ParkingFloor;
import ParkingLot.Entities.ParkingSpot;
import ParkingLot.Entities.ParkingTicket;
import ParkingLot.Strategy.Fee.FeeStrategy;
import ParkingLot.Strategy.Fee.VehicleBasedFeeStrategy;
import ParkingLot.Strategy.Parking.NearestFirstStrategy;
import ParkingLot.Strategy.Parking.Parkingstrategy;
import ParkingLot.Vehicle.Vehicle;

public class ParkingLotSystem {
    private static ParkingLotSystem parkingLotSystem;
    private final List<ParkingFloor> floors=new ArrayList<>();
    private final Map<String,ParkingTicket> activeTickets;
    private FeeStrategy feeStrategy;
    private Parkingstrategy parkingStrategy;
    private ParkingLotSystem(){
        this.activeTickets=new ConcurrentHashMap<>();
        this.feeStrategy=new VehicleBasedFeeStrategy();
        this.parkingStrategy=new NearestFirstStrategy();
    }
    public static synchronized ParkingLotSystem getInstance(){
        if(parkingLotSystem==null){
            parkingLotSystem=new ParkingLotSystem();
        }
        return parkingLotSystem;
    }
    public void addFloor(ParkingFloor floor){
        floors.add(floor);
    }
    public void setFeeStrategy(FeeStrategy feeStrategy){
        this.feeStrategy=feeStrategy;
    }
    public void setParkingStrategy(Parkingstrategy parkingstrategy){
        this.parkingStrategy=parkingstrategy;
    }
    public Optional<ParkingTicket> parkVehicle(Vehicle vehicle){
        Optional<ParkingSpot> availablespot=parkingStrategy.findSpot(floors, vehicle);
        if(availablespot.isPresent()){
            ParkingSpot spot=availablespot.get();
            spot.parkedVehicle(vehicle);
            ParkingTicket ticket=new ParkingTicket(vehicle, spot);
            activeTickets.put(vehicle.getLicenseNumber(),ticket);
            System.out.println("Ticket Genertated with ticket number "+ ticket.getTicket());
            return Optional.of(ticket);
        }
        System.out.println("No available spots");
        return Optional.empty();
    }
    public Optional<Double> unParkVehicle(String licenseNumber){
        ParkingTicket ticket=activeTickets.get(licenseNumber);
        if(ticket==null){
            System.out.println("Ticket not found");
            return Optional.empty();
        }
        ticket.setExitTimeStamp();
        ticket.getSpot().unparkVehicle();
        activeTickets.remove(licenseNumber);
        Double parkingFee= feeStrategy.calculateFee(ticket);
        return Optional.of(parkingFee);
        
    }
}
