package ParkingLot.Strategy.Fee;

import java.util.Map;
import ParkingLot.Entities.ParkingTicket;
import ParkingLot.Vehicle.VehicleSize;

public class VehicleBasedFeeStrategy implements FeeStrategy{
    private static final Map<VehicleSize,Double> HOURLY_RATES=Map.of(
        VehicleSize.SMALL,10.0,
        VehicleSize.MEDIUM,20.0,
        VehicleSize.LARGE,30.0
    );
    @Override
    public double calculateFee(ParkingTicket ticket) {
        // TODO Auto-generated method stub
        long duration=ticket.getExitTimeStamp()-ticket.getEntryTimeStamp();
        long hours=(duration/(1000*60*60))+1;
        return hours*HOURLY_RATES.get(ticket.getVehicle().getSize());
        //throw new UnsupportedOperationException("Unimplemented method 'calculateFee'");
    }
    
}
