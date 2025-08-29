package ParkingLot;

import java.util.Optional;

import ParkingLot.Entities.ParkingFloor;
import ParkingLot.Entities.ParkingSpot;
import ParkingLot.Entities.ParkingTicket;
import ParkingLot.Strategy.Fee.VehicleBasedFeeStrategy;
import ParkingLot.Vehicle.Bike;
import ParkingLot.Vehicle.Car;
import ParkingLot.Vehicle.Truck;
import ParkingLot.Vehicle.Vehicle;
import ParkingLot.Vehicle.VehicleSize;

public class ParkingLotDemo {
    public static void main(String[] args) {
        ParkingLotSystem parkingLot = ParkingLotSystem.getInstance();

        // 1. Initialize the parking lot with floors and spots
        ParkingFloor floor1 = new ParkingFloor(1);
        floor1.addSpot(new ParkingSpot(VehicleSize.SMALL, "F1-S1"));
        floor1.addSpot(new ParkingSpot(VehicleSize.MEDIUM, "F1-M1"));
        floor1.addSpot(new ParkingSpot(VehicleSize.LARGE, "F1-L1"));

        ParkingFloor floor2 = new ParkingFloor(2);
        floor2.addSpot(new ParkingSpot(VehicleSize.MEDIUM, "F2-M1"));
        floor2.addSpot(new ParkingSpot(VehicleSize.MEDIUM, "F2-M2"));

        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);

        parkingLot.setFeeStrategy(new VehicleBasedFeeStrategy());

        // 2. Simulate vehicle entries
        System.out.println("\n--- Vehicle Entries ---");
        floor1.dispayAvailablity();
        floor2.dispayAvailablity();

        Vehicle bike = new Bike("B-123");
        Vehicle car = new Bike("C-456");
        Vehicle truck = new Truck("T-789");

        Optional<ParkingTicket> bikeTicketOpt = parkingLot.parkVehicle(bike);

        Optional<ParkingTicket> carTicketOpt = parkingLot.parkVehicle(car);

        Optional<ParkingTicket> truckTicketOpt = parkingLot.parkVehicle(truck);

        System.out.println("\n--- Availability after parking ---");
        floor1.dispayAvailablity();
        floor2.dispayAvailablity();

        // 3. Simulate another car entry (should go to floor 2)
        Vehicle car2 = new Bike ("C-999");
        Optional<ParkingTicket> car2TicketOpt = parkingLot.parkVehicle(car2);

        // 4. Simulate a vehicle entry that fails (no available spots)
        Vehicle bike2 = new Bike("B-000");
        Optional<ParkingTicket> failedBikeTicketOpt = parkingLot.parkVehicle(bike2);

        // 5. Simulate vehicle exits and fee calculation
        System.out.println("\n--- Vehicle Exits ---");

        if (carTicketOpt.isPresent()) {
            Optional<Double> feeOpt = parkingLot.unParkVehicle(car.getLicenseNumber());
            feeOpt.ifPresent(fee -> System.out.printf("Car C-456 unparked. Fee: $%.2f\n", fee));
        }

        System.out.println("\n--- Availability after one car leaves ---");
        floor1.dispayAvailablity();
        floor2.dispayAvailablity();
    }
    
}
