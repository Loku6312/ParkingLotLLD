package ParkingLot.Vehicle;
@getter
public abstract class Vehicle {
    private final String licenseNumber;
    private final VehicleSize size;
    private String DriverName;
    private String phoneNumber;
    Vehicle(String licenseNumber,VehicleSize size){
        this.licenseNumber=licenseNumber;
        this.size=size;
    }
    public void setDriverDetails(String DriverName,String phoneNumber){
        this.DriverName=DriverName;
        this.phoneNumber=phoneNumber;
    }
    public VehicleSize getSize(){
        return size;
    }
    public String getLicenseNumber(){
        return licenseNumber;
    }
}
