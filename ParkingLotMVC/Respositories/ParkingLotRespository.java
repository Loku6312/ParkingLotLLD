package Respositories;

import java.util.Date;
import java.util.TreeMap;

import models.Gate;
import models.ParkingLot;

public class ParkingLotRespository {
    TreeMap<Long,ParkingLot> parkingLotStore=new TreeMap<>();
    Long previousId=0l;
    public ParkingLot save(ParkingLot parkingLot){
        parkingLot.setId(previousId++);
        parkingLot.setCreatedAt(new Date());
        parkingLot.setUpdatedAt(new Date());
        parkingLotStore.put(previousId,parkingLot);
        return parkingLot;
    }
    public ParkingLot getParkingLotByGate(Gate gate){
        return gate.getParkingLot();
    }
    
}
