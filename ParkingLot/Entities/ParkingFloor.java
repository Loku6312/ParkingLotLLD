package ParkingLot.Entities;

//import java.net.SocketTimeoutException;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
//import java.util.stream.Collector;
import java.util.stream.Collectors;

import ParkingLot.Vehicle.Vehicle;
import ParkingLot.Vehicle.VehicleSize;

public class ParkingFloor {
    private final int floorNumber;
    private final Map<String,ParkingSpot> spots;
    
    public ParkingFloor(int floorNumber){
        this.floorNumber=floorNumber;
        this.spots=new ConcurrentHashMap<>();
    }
    public void addSpot(ParkingSpot spot){
        spots.put(spot.getSpotId(),spot);
    }
    public synchronized Optional<ParkingSpot> findAvailableSpot(Vehicle vehicle){
        return spots.values().stream()
                .filter(spot->!spot.isOccupied() && spot.canFitVehicle(vehicle)).sorted(Comparator.comparing(ParkingSpot::getSpotSize)).findFirst();
    }
    public void dispayAvailablity(){
        System.out.printf("-----Floor %d Availablity---------\n",floorNumber);
        Map<VehicleSize,Long> availableCounts=spots.values().stream().filter(spot->!spot.isOccupied()).collect(Collectors.groupingBy(ParkingSpot::getSpotSize,Collectors.counting()));
        for(VehicleSize size:VehicleSize.values()){
            System.out.printf("  %s spots: %d\n", size, availableCounts.getOrDefault(size, 0L));
        }
    }

    
    

    
    
}
