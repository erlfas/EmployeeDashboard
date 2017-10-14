package no.fasmer.employeedashboard.entity;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue(value = "FullTimeEmployee")
public class FullTimeEmployee extends Employee implements Serializable {
    
    @NotNull
    protected Integer salary;

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
    
}
