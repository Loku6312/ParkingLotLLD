package models;

import java.util.Date;

public class BaseClass {
    private Long id;
    private Date created_at;
    private Date update_at;
    public void setId(Long id){
        this.id=id;
    }
    public void setCreatedAt(Date created_at){
        this.created_at=created_at;
    }
    public void setUpdatedAt(Date updated_at){
        this.update_at=updated_at;
    }
    public Long getId(){
        return id;
    }
    public Date getCreatedAt(){
        return created_at;
    }
    public Date getUpdateAt(){
        return update_at;
    }
}