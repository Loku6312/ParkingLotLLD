import java.util.ArrayList;
import java.util.List;

import Controllers.TicketControllers;
import DTOS.IssuTicketRequestDTO;
import DTOS.IssueTicketResponseDTO;
import Respositories.ActiveTicketRespository;
import Respositories.GateRespository;
import Respositories.ParkingLotRespository;
import Respositories.VehicleRespository;
import Services.TicketService;
import models.AllowedVehicles;
import models.Gate;
import models.GateStatus;
import models.GateType;
import models.Operator;
import models.ParkingFloor;
import models.ParkingFloorStatus;
import models.ParkingLot;
import models.ParkingLotStatus;
import models.ParkingSlot;
import models.ParkingSlotStatus;
import models.ResponseStatus;
import models.SlotAllocationType;
import models.VehicleType;

public class Client {
    public static void main(String[] args) {
        // create controller
        // create service
        // create repository

        GateRespository gateRepository = new GateRespository();
        VehicleRespository vehicleRepository = new VehicleRespository();
        ParkingLotRespository parkingLotRepository  =new ParkingLotRespository();
        ActiveTicketRespository activeTicketRespository=new ActiveTicketRespository();

        TicketService ticketService = new TicketService(vehicleRepository,gateRepository,parkingLotRepository,activeTicketRespository);
        TicketControllers ticketController = new TicketControllers(ticketService);
        // Generate some pre data
        // Some gates, a parking lot, a parking, some parking slots
        Operator operator = new Operator("Akash", "NT155");
        Gate gateEntry1 =  new Gate(12, GateType.ENTRY, GateStatus.OPEN, operator);
        Gate gateEntry2 =  new Gate(13, GateType.ENTRY, GateStatus.OPEN, operator);
        Gate gateExit1 =  new Gate(14, GateType.ENTRY, GateStatus.OPEN, operator);
        Gate gateExit2 =  new Gate(15, GateType.ENTRY, GateStatus.OPEN, operator);

        ParkingLot parkingLot = new ParkingLot("Lodha Amara A");
        parkingLot.setParkingLotStatus(ParkingLotStatus.EMPTY);
        gateEntry1.setParkingLot(parkingLot);
        gateEntry2.setParkingLot(parkingLot);
        gateExit1.setParkingLot(parkingLot);
        gateExit2.setParkingLot(parkingLot);


        //Entry gates
        List<Gate> entrygates = new ArrayList<>();
        entrygates.add(gateEntry1);
        entrygates.add(gateEntry2);
        parkingLot.setEntryGates(entrygates);

        //Exit gates
        List<Gate> exitGates = new ArrayList<>();
        exitGates.add(gateExit1);
        exitGates.add(gateExit2);
        parkingLot.setExitGates(exitGates);

        //Allocation strategy type
        parkingLot.setSlotAllocationType(SlotAllocationType.RANDOM);

//        parkingLot.setSupportedVehicleTypes(null);
        parkingLot.setId(1234123L);


        ParkingFloor parkingFloor = new ParkingFloor();
        parkingFloor.setFloorNo(1);
        parkingFloor.setFloorStatus(ParkingFloorStatus.OPEN);

        List<ParkingSlot> parkingSlots = new ArrayList<>();
        List<AllowedVehicles> av1List = new ArrayList<>();
        av1List.add(new AllowedVehicles(VehicleType.BIKE, 3));
        List<AllowedVehicles> av2List = new ArrayList<>();
        av2List.add(new AllowedVehicles(VehicleType.CAR, 1));
        List<AllowedVehicles> av3List = new ArrayList<>();
        av3List.add(new AllowedVehicles(VehicleType.BIKE, 1));
        List<AllowedVehicles> av4List = new ArrayList<>();
        av4List.add(new AllowedVehicles(VehicleType.CAR, 1));


        parkingSlots.add(new ParkingSlot("1", ParkingSlotStatus.EMPTY, av1List ));
        parkingSlots.add(new ParkingSlot("2", ParkingSlotStatus.EMPTY, av2List));
        parkingSlots.add(new ParkingSlot("3", ParkingSlotStatus.EMPTY, av3List));
        parkingSlots.add(new ParkingSlot("4", ParkingSlotStatus.EMPTY, av4List));
        parkingFloor.setParkingSlots(parkingSlots);

        List<ParkingFloor> parkingFloorList = new ArrayList<>();
        parkingFloorList.add(parkingFloor);

        parkingLot.setFloors(parkingFloorList);
        gateEntry1.setParkingLot(parkingLot);
        gateEntry2.setParkingLot(parkingLot);
        gateExit1.setParkingLot(parkingLot);
        gateExit2.setParkingLot(parkingLot);

        gateRepository.save(gateEntry1);
        gateRepository.save(gateEntry2);
        gateRepository.save(gateExit1);
        gateRepository.save(gateExit2);

        parkingLotRepository.save(parkingLot);

        IssuTicketRequestDTO requestDTO = new IssuTicketRequestDTO();
        requestDTO.setGateId(1l);
        requestDTO.setOwnerName("Sam");
        requestDTO.setOwnerContact("0000000000");
        requestDTO.setRegNumber("MA12566788");
        requestDTO.setVehicleType(VehicleType.CAR);

        IssueTicketResponseDTO responseDTO = ticketController.createTicket(requestDTO);

        if(responseDTO.getResponseStatus().equals(ResponseStatus.SUCCESS)){
            System.out.println(responseDTO.getResponseMessage());

            System.out.println("Ticket : " + responseDTO.getTicketNumber() + " at slot :" + responseDTO.getSlotNumber());
        }else{
            System.out.println(responseDTO.getResponseMessage());
        }

        IssuTicketRequestDTO requestDTO2 = new IssuTicketRequestDTO();
        requestDTO2.setGateId(1l);
        requestDTO2.setOwnerName("Sami");
        requestDTO2.setOwnerContact("0000000000");
        requestDTO2.setRegNumber("MA12566789");
        requestDTO2.setVehicleType(VehicleType.CAR);

        IssueTicketResponseDTO responseDTO2 = ticketController.createTicket(requestDTO2);

        if(responseDTO2.getResponseStatus().equals(ResponseStatus.SUCCESS)){
            System.out.println(responseDTO2.getResponseMessage());
            System.out.println("Ticket : " + responseDTO2.getTicketNumber() + " at slot :" + responseDTO2.getSlotNumber());
        }else{
            System.out.println(responseDTO2.getResponseMessage());
        }

    }
    
}
