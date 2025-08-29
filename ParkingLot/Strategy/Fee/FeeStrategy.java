package ParkingLot.Strategy.Fee;

import ParkingLot.Entities.ParkingTicket;

public interface FeeStrategy {
    double calculateFee(ParkingTicket ticket);
}
