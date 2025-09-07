package Respositories;

import java.util.Date;
import java.util.Optional;
import java.util.TreeMap;

import models.Gate;

public class GateRespository {
    TreeMap<Long,Gate> gateStore=new TreeMap<>();
    Long previousId=0l;
    public Gate save(Gate gate){
        gate.setId(previousId++);
        gate.setCreatedAt(new Date());
        gate.setUpdatedAt(new Date());
        gateStore.put(previousId,gate);
        return gate;
    }
    public Optional<Gate> getGateById(Long gateId){
        if(gateStore.containsKey(gateId)){
            return Optional.of(gateStore.get(gateId));
        }
        return Optional.of(null);
    }
}
