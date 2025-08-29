package ParkingLot.Strategy.Parking;

import java.util.List;
import java.util.Optional;

import ParkingLot.Entities.ParkingFloor;
import ParkingLot.Entities.ParkingSpot;
import ParkingLot.Vehicle.Vehicle;

public class NearestFirstStrategy implements Parkingstrategy{

    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle) {
        // TODO Auto-generated method stub
        for(ParkingFloor floor:floors){
            Optional<ParkingSpot> spot=floor.findAvailableSpot(vehicle);
            if(spot.isPresent()){
                return spot;
            }
        }
        return Optional.empty();
        //throw new UnsupportedOperationException("Unimplemented method 'findSpot'");
    }
    
}
