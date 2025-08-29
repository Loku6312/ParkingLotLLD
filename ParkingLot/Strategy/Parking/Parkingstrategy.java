package ParkingLot.Strategy.Parking;

import java.util.List;
import java.util.Optional;

import ParkingLot.Entities.ParkingFloor;
import ParkingLot.Entities.ParkingSpot;
import ParkingLot.Vehicle.Vehicle;

public interface Parkingstrategy {
    Optional<ParkingSpot> findSpot(List<ParkingFloor> floors,Vehicle vehicle);
}
