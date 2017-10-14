package no.fasmer.employeedashboard.entity;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue(value = "PartTimeEmployee")
public class PartTimeEmployee extends Employee implements Serializable {
    
    @NotNull
    protected Integer hourlyWage;

    public Integer getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(Integer hourlyWage) {
        this.hourlyWage = hourlyWage;
    }
    
}
