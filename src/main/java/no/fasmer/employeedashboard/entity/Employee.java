package no.fasmer.employeedashboard.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // default
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Employee implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long employeeId;
    
    @NotNull
    protected String firstName;
    
    @NotNull
    protected String lastName;
    
    @Embedded
    protected Address address;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Past
    protected Date dateOfBirth;
    
    @Embedded
    protected EmploymentPeriod employmentPeriod;
    
    @Embedded
    protected ContactInformation contactInformation;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    protected List<AreaOfExpertise> areaOfExpertises;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public EmploymentPeriod getEmploymentPeriod() {
        return employmentPeriod;
    }

    public void setEmploymentPeriod(EmploymentPeriod employmentPeriod) {
        this.employmentPeriod = employmentPeriod;
    }

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    public List<AreaOfExpertise> getAreaOfExpertises() {
        return areaOfExpertises;
    }

    public void setAreaOfExpertises(List<AreaOfExpertise> areaOfExpertises) {
        this.areaOfExpertises = areaOfExpertises;
    }
    
    public void addAreaOfExpertise(AreaOfExpertise areaOfExpertise) {
        this.areaOfExpertises.add(areaOfExpertise);
        if (areaOfExpertise.getExpert() != this) {
            areaOfExpertise.setExpert(this);
        }
    }
    
}
