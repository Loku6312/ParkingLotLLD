package Strategies;

import java.util.Optional;

import models.ParkingLot;
import models.ParkingSlot;
import models.VehicleType;

public interface SlotAllocationStrategy {
    public Optional<ParkingSlot> assignSlot(ParkingLot parkingLot,VehicleType vehicleType);
}
