package models;

public class Operator extends BaseClass{
    private String name;
    private String emp_id;
    private Gate gate;
    public Operator(String name,String emp_id){
        this.name=name;
        this.emp_id=emp_id;
        //this.gate=gate;
    }
    public String getName(){
        return name;
    }
    public String getEmpId(){
        return emp_id;
    }
    public Gate getGate(){
        return gate;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setEmpId(String emp_id){
        this.emp_id=emp_id;
    }
    public void setGate(Gate gate){
        this.gate=gate;
    }
}
