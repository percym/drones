package com.musala.drones.base;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
@Data
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 8662079809319279877L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long  id;

    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }
        if (!(o instanceof BaseEntity)) {
            return false;
        }
        BaseEntity baseEntity = (BaseEntity) o;

        return id.equals(baseEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
