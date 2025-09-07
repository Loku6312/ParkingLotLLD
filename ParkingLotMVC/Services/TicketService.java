package Services;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

//import javax.management.RuntimeErrorException;

import Factory.SlotAllocationStrategyFactory;
import Respositories.ActiveTicketRespository;
import Respositories.GateRespository;
import Respositories.ParkingLotRespository;
import Respositories.VehicleRespository;
import models.Gate;
//import models.ParkingFloorStatus;
import models.ParkingLot;
import models.ParkingSlot;
import models.Ticket;
import models.Vehicle;
import models.VehicleType;

public class TicketService {
    private GateRespository gateRespository;
    private ParkingLotRespository parkingLotRespository;
    private VehicleRespository vehicleRespository;
    private ActiveTicketRespository activeTicketRespository;
    public TicketService(VehicleRespository vehicleRepository,GateRespository gateRepository,ParkingLotRespository parkingLotRepository,ActiveTicketRespository activeTicketRespository){
        this.gateRespository=gateRepository;
        this.parkingLotRespository=parkingLotRepository;
        this.vehicleRespository=vehicleRepository;
        this.activeTicketRespository=activeTicketRespository;
    }
    public Ticket createTicket(String reg_number,VehicleType vehicleType,String owner_name,String owner_contact,
Long gate_id){
    Optional<Gate> gateOptional=gateRespository.getGateById(gate_id);
    if(gateOptional.isEmpty()){
        throw new RuntimeException("Invalid Gate");
    }
    Gate gate=gateOptional.get();
    Ticket ticket=new Ticket();
    ticket.setNumber(UUID.randomUUID().toString());
    ticket.setGate(gate);
    ticket.setEntryTime(new Date());
    ticket.setOperator(gate.getOperator());
    Vehicle vehicle=vehicleRespository.findOrCreateVehicle(reg_number,owner_name,owner_contact,vehicleType);
    ticket.setVehicle(vehicle);
    ParkingLot parkingLot=gate.getParkingLot();
    Optional<ParkingSlot> parkingslotOptional=SlotAllocationStrategyFactory.getStrategy(parkingLot.getSlotAllocationType(), parkingLotRespository).assignSlot(parkingLot, vehicleType);
    if(parkingslotOptional.isEmpty()){
        throw new RuntimeException("ParkingLot is Filled");
    }
    ticket.setParkingSlot(parkingslotOptional.get());
    activeTicketRespository.addActiveTicket(ticket.getNumber(),ticket.getEntryTime());
    return ticket;
}
    
}
