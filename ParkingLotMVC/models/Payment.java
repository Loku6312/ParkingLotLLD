package models;

public class Payment extends BaseClass{
    private Bill bill;
    private String txn_id;
    private PaymentMode mode;
    private Double amount;
    public Bill getBill(){
        return bill;
    }
    public void setBill(Bill bill){
        this.bill=bill;
    }
    public String getTxnId(){
        return txn_id;
    }
    public void setTxnId(String txn_id){
        this.txn_id=txn_id;
    }
    public PaymentMode getPaymentMode(){
        return mode;
    }
    public void setPaymentMode(PaymentMode paymentMode){
        this.mode=paymentMode;
    }
    public Double getAmountDouble(){
        return amount;
    }
    public void setAmount(Double amount){
        this.amount=amount;
    }

}
