package Factory;

import Respositories.ParkingLotRespository;
import Strategies.RandomSlotAllocationStrategy;
import Strategies.SlotAllocationStrategy;
import models.SlotAllocationType;

public class SlotAllocationStrategyFactory {
    public static SlotAllocationStrategy getStrategy(SlotAllocationType type,ParkingLotRespository parkingLotRespository){
        if(type.equals(SlotAllocationType.RANDOM)){
            return new RandomSlotAllocationStrategy(parkingLotRespository);
        }
        throw new RuntimeException("Invalid slot allocation type");
    }
    
}
