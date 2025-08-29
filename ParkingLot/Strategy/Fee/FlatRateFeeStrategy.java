package ParkingLot.Strategy.Fee;

import ParkingLot.Entities.ParkingTicket;

class FlatRateFeeStrategy implements FeeStrategy{
    private static final double RATE_PER_HOUR=10.0;
    @Override
    public double calculateFee(ParkingTicket ticket) {
        // TODO Auto-generated method stub
        long duration=ticket.getExitTimeStamp()-ticket.getEntryTimeStamp();
        long hours=(duration/(1000*60*60))+1;
        return hours*RATE_PER_HOUR;
        //throw new UnsupportedOperationException("Unimplemented method 'calculateFee'");
    }

}