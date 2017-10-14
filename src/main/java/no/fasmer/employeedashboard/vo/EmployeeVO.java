package no.fasmer.employeedashboard.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import no.fasmer.employeedashboard.enums.EmployeeType;

public class EmployeeVO implements Serializable {
    
    private EmployeeType type;
    
    private String firstName;

    private String lastName;

    private String street;
    
    private String streetNo;
    
    private String postalCode;
    
    private String city;

    private Date dateOfBirth;

    private Date startDate;
    
    private Date endDate;

    private String email;
    
    private String mobilePhone;
    
    private Integer salary;
    
    private Integer hourlyWage;
    
    protected List<String> areaOfExpertises;

    public EmployeeVO() {
        this.type = EmployeeType.FULL_TIME_EMPLOYEE;
    }

    public EmployeeVO(
            String firstName, String lastName, String street, String streetNo, 
            String postalCode, String city, Date dateOfBirth, Date startDate, 
            Date endDate, String email, String mobilePhone) {
        
        this.type = EmployeeType.FULL_TIME_EMPLOYEE;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.streetNo = streetNo;
        this.postalCode = postalCode;
        this.city = city;
        this.dateOfBirth = dateOfBirth;
        this.startDate = startDate;
        this.endDate = endDate;
        this.email = email;
        this.mobilePhone = mobilePhone;
        
    }

    public EmployeeType getType() {
        return type;
    }
    
    public boolean isFullTimeEmployee() {
        return type == EmployeeType.FULL_TIME_EMPLOYEE;
    }
    
    public boolean isPartTimeEmployee() {
        return type == EmployeeType.PART_TIME_EMPLOYEE;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public void setType(String type) {
        this.type = EmployeeType.valueOf(type);
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(Integer hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public List<String> getAreaOfExpertises() {
        return areaOfExpertises;
    }

    public void setAreaOfExpertises(List<String> areaOfExpertises) {
        this.areaOfExpertises = areaOfExpertises;
    }
    
    public void addAreaOfExpertise(String areaOfExpertise) {
        if (this.areaOfExpertises == null) {
            this.areaOfExpertises = new ArrayList<>();
        }
        
        this.areaOfExpertises.add(areaOfExpertise);
    }
    
}
