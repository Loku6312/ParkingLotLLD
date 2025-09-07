package models;

public class Gate extends BaseClass{
    private GateStatus status;
    private GateType type;
    private ParkingLot parkinglot;
    private Operator operator;
    private Integer gateNo;
    public GateStatus getGateStatus(){
        return status;
    }
    public GateType getGateType(){
        return type;
    }
    public ParkingLot getParkingLot(){
        return parkinglot;
    }
    public Integer getGateNo(){
        return gateNo;
    }
    public Operator getOperator(){
        return operator;
    }
    public Gate(Integer gateNo,GateType type,GateStatus status,Operator operator){
        this.type=type;
        //this.parkinglot=parkingLot;
        this.operator=operator;
        this.gateNo=gateNo;
        this.status=status;
    }
    public void setGateStatus(GateStatus status){
        this.status=status;
    }
    public void setType(GateType type){
        this.type=type;
    }
    public void setParkingLot(ParkingLot parkingLot){
        this.parkinglot=parkingLot;
    }
    public void setOperator(Operator operator){
        this.operator=operator;
    }
    public void setGateNo(Integer gateNo){
        this.gateNo=gateNo;
    }
}

