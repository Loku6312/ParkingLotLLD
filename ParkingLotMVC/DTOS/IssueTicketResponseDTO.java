package DTOS;

import java.util.Date;

import models.ResponseStatus;

public class IssueTicketResponseDTO {
    private String ticket_number;
    private Date entry_Time;
    private String slot_number;
    private String ResponseMessage;
    private ResponseStatus responseStatus;
    public IssueTicketResponseDTO(){

    }
    public void setResponseStatus(ResponseStatus responseStatus){
        this.responseStatus=responseStatus;
    }
    public ResponseStatus getResponseStatus(){
        return responseStatus;
    }
    public String getResponseMessage(){
        return ResponseMessage;
    }
    public void setResponseMessage(String ResponseMessage){
        this.ResponseMessage=ResponseMessage;
    }
    public IssueTicketResponseDTO(String ticket_number,Date entry_Time,String slot_number){
        this.ticket_number=ticket_number;
        this.entry_Time=entry_Time;
        this.slot_number=slot_number;
    }
    public String getTicketNumber(){
        return ticket_number;
    }
    public void setTicketNumber(String ticket_number){
        this.ticket_number=ticket_number;
    }
    public Date getEntryTime(){
        return entry_Time;
    }
    public void setEntryTime(Date entry_Time){
        this.entry_Time=entry_Time;
    }
    public void setSlotNumber(String slot_number){
        this.slot_number=slot_number;
    }
    public String getSlotNumber(){
        return slot_number;
    }
}
