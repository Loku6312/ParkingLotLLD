package Respositories;

import java.util.Date;
import java.util.TreeMap;

import models.Vehicle;
import models.VehicleType;

public class VehicleRespository {
    TreeMap<String,Vehicle> vehicleStore=new TreeMap<>();
    Long previousID=0l;
    public Vehicle save(Vehicle vehicle){
        vehicle.setId(previousID++);
        vehicle.setCreatedAt(new Date());
        vehicle.setUpdatedAt(new Date());
        vehicleStore.put(vehicle.getRegNumber(),vehicle);
        return vehicle;
    }
    public Vehicle findOrCreateVehicle(String reg_number,String owner_name,String owner_contact,VehicleType vehicleType){
        if(vehicleStore.containsKey(reg_number)){
            return vehicleStore.get(reg_number);
        }
        Vehicle vehicle=new Vehicle(reg_number, owner_name, owner_contact, vehicleType);
        return save(vehicle);
    }
    
}
