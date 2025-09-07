package models;

import java.util.Date;
import java.util.List;

public class Bill extends BaseClass{
    private Double amount;
    private Date exit_Time;
    private List<Payment> payments;
    private Ticket ticket;
    private Operator operator;
    private Gate gate;
    private BillStatus billStatus;
    public Double getAmount(){
        return amount;
    }
    public void setAmount(Double amount){
        this.amount=amount;
    }
    public Date getExitTime(){
        return exit_Time;
    }
    public void setExitTime(Date exit_Time){
        this.exit_Time=exit_Time;
    }
    public List<Payment> getPayments(){
        return payments;
    }
    public void setPayments(List<Payment> payments){
        this.payments=payments;
    }
    public Ticket getTicket(){
        return ticket;
    }
    public void setTicket(Ticket ticket){
        this.ticket=ticket;
    }
    public Operator getOperator(){
        return operator;
    }
    public void setOperator(Operator operator){
        this.operator=operator;
    }
    public Gate getGate(){
        return gate;
    }
    public void setGate(Gate gate){
        this.gate=gate;
    }
    public BillStatus getBillStatus(){
        return billStatus;
    }
    public void setBillStatus(BillStatus billStatus){
        this.billStatus=billStatus;
    }

    
}
