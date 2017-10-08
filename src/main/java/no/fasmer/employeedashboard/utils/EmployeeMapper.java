package no.fasmer.employeedashboard.utils;

import no.fasmer.employeedashboard.entity.Address;
import no.fasmer.employeedashboard.entity.AreaOfExpertise;
import no.fasmer.employeedashboard.entity.ContactInformation;
import no.fasmer.employeedashboard.entity.Employee;
import no.fasmer.employeedashboard.entity.EmploymentPeriod;
import no.fasmer.employeedashboard.entity.FullTimeEmployee;
import no.fasmer.employeedashboard.entity.PartTimeEmployee;
import no.fasmer.employeedashboard.vo.EmployeeVO;

public class EmployeeMapper {

    public static EmployeeVO map(Employee employee) {
        final EmployeeVO vo = new EmployeeVO();

        vo.setFirstName(employee.getFirstName());
        vo.setLastName(employee.getLastName());
        vo.setDateOfBirth(employee.getDateOfBirth());

//        for (AreaOfExpertise areaOfExpertise : employee.getAreaOfExpertises()) {
//            vo.addAreaOfExpertise(areaOfExpertise.getExpertise());
//        }

        if (employee.getAddress() != null) {
            vo.setCity(employee.getAddress().getCity());
            vo.setPostalCode(employee.getAddress().getPostalCode());
            vo.setStreet(employee.getAddress().getStreet());
            vo.setStreetNo(employee.getAddress().getStreetNo());
        }

        if (employee.getEmploymentPeriod() != null) {
            vo.setStartDate(employee.getEmploymentPeriod().getStartDate());
            vo.setEndDate(employee.getEmploymentPeriod().getEndDate());
        }

        if (employee.getContactInformation() != null) {
            vo.setEmail(employee.getContactInformation().getEmail());
            vo.setMobilePhone(employee.getContactInformation().getMobilePhone());
        }

        return vo;
    }

    public static Employee map(EmployeeVO vo) {
        final Employee employee;
        switch (vo.getType()) {
            default:
            case FULL_TIME_EMPLOYEE:
                employee = new FullTimeEmployee();
                break;
            case PART_TIME_EMPLOYEE:
                employee = new PartTimeEmployee();
                break;
        }

        employee.setFirstName(vo.getFirstName());
        employee.setLastName(vo.getLastName());

        final Address address = new Address();
        address.setCity(vo.getCity());
        address.setPostalCode(vo.getPostalCode());
        address.setStreet(vo.getStreet());
        address.setStreetNo(vo.getStreetNo());
        employee.setAddress(address);

        final ContactInformation contactInformation = new ContactInformation();
        contactInformation.setEmail(vo.getEmail());
        contactInformation.setMobilePhone(vo.getMobilePhone());
        employee.setContactInformation(contactInformation);

        employee.setDateOfBirth(vo.getDateOfBirth());

        final EmploymentPeriod employmentPeriod = new EmploymentPeriod();
        employmentPeriod.setStartDate(vo.getStartDate());
        employmentPeriod.setEndDate(vo.getEndDate());
        employee.setEmploymentPeriod(employmentPeriod);

//        for (String areaOfExpertiseStr : vo.getAreaOfExpertises()) {
//            final AreaOfExpertise areaOfExpertise = new AreaOfExpertise();
//            areaOfExpertise.setEmployee(employee);
//            areaOfExpertise.setExpertise(areaOfExpertiseStr);
//            employee.addAreaOfExpertise(areaOfExpertise);
//        }

        return employee;
    }

}
