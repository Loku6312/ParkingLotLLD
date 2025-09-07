package Controllers;

import DTOS.IssuTicketRequestDTO;
import DTOS.IssueTicketResponseDTO;
import Services.TicketService;
import models.ResponseStatus;
import models.Ticket;

public class TicketControllers {
    private TicketService ticketService;
    public TicketControllers(TicketService ticketService){
        this.ticketService=ticketService;
    }
    public IssueTicketResponseDTO createTicket(IssuTicketRequestDTO requestDTO){
        IssueTicketResponseDTO responseDTO;
        try{
            Ticket ticket=ticketService.createTicket(requestDTO.getRegNumber(),requestDTO.getVehicleType(),requestDTO.getOwnerName(), requestDTO.getOwnerContact(),requestDTO.getGateId());
            responseDTO=new IssueTicketResponseDTO(ticket.getNumber(), ticket.getEntryTime(),ticket.getParkingSlot().getNumber());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setResponseMessage("Ticket Generated successfully");
        }catch(Exception e){
            System.out.println("Error occured "+e.getMessage());
            responseDTO=new IssueTicketResponseDTO();
            responseDTO.setResponseStatus(ResponseStatus.FAILED);
            responseDTO.setResponseMessage("Ticket creation failed "+e.getMessage());
        }
        return responseDTO;

        
    }
    
    
}
