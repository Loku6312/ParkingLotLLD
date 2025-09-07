package Strategies;

import java.util.List;
import java.util.Optional;

import Respositories.ParkingLotRespository;
import models.AllowedVehicles;
import models.ParkingFloor;
import models.ParkingFloorStatus;
import models.ParkingLot;
import models.ParkingLotStatus;
import models.ParkingSlot;
import models.ParkingSlotStatus;
import models.VehicleType;

public class RandomSlotAllocationStrategy implements SlotAllocationStrategy{
    private ParkingLotRespository parkingLotRespository;
    public RandomSlotAllocationStrategy(ParkingLotRespository parkingLotRespository){
        this.parkingLotRespository=parkingLotRespository;
    }

    @Override
    public Optional<ParkingSlot> assignSlot(ParkingLot parkingLot, VehicleType vehicleType) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'assignSlot'");
        if(parkingLot.getParkingLotStatus().equals(ParkingLotStatus.FILLED)){
            return Optional.of(null);
        }
        List<ParkingFloor> floors=parkingLot.getFloors();
        for(ParkingFloor floor: floors){
            if(floor.getFloorStatus().equals(ParkingFloorStatus.FILLED)){
                continue;
            }
            for(ParkingSlot slot:floor.getParkingSlots()){
                if(slot.geParkingSlotStatus().equals(ParkingSlotStatus.EMPTY)){
                    for(AllowedVehicles vehicle:slot.getAllowedVehicles()){
                        if(vehicle.getVehicleType().equals(vehicleType )&& vehicle.getCapacity() > 0){
                            vehicle.setCapacity(vehicle.getCapacity()-1);
                            slot.setParkingSlotStatus(ParkingSlotStatus.FILLED);
                            return Optional.of(slot);
                        }
                    }
                }
            }
        }
        return Optional.of(null);

    }
    
}
