package Respositories;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

//import javax.print.attribute.HashAttributeSet;

//import models.Ticket;

public class ActiveTicketRespository {
    Map<String,Date> activeTickets=new HashMap<>();
    public Optional<Date> getTicket(String number){
        if(activeTickets.containsKey(number)){
            return Optional.of(activeTickets.get(number));
        }
        return Optional.empty();
    }
    public void addActiveTicket(String number,Date entryTime){
        activeTickets.put(number,entryTime);
    }
    public void RemoveTicket(String number){
        if(activeTickets.containsKey(number)){
            activeTickets.remove(number);
        }else{
            throw new RuntimeException("Ticket not found");
        }
    }
    


    
}
