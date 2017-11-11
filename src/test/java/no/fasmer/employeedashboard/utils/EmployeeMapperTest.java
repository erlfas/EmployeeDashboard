package no.fasmer.employeedashboard.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import no.fasmer.employeedashboard.entity.Address;
import no.fasmer.employeedashboard.entity.ContactInformation;
import no.fasmer.employeedashboard.entity.Employee;
import no.fasmer.employeedashboard.entity.EmploymentPeriod;
import no.fasmer.employeedashboard.entity.FullTimeEmployee;
import no.fasmer.employeedashboard.entity.PartTimeEmployee;
import no.fasmer.employeedashboard.enums.EmployeeType;
import no.fasmer.employeedashboard.vo.EmployeeVO;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeMapperTest {
    
    public EmployeeMapperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testMap_Employee() {
        final Date date = new Date();
        
        final Address address = new Address();
        address.setCity("Bergen");
        address.setPostalCode("5006");
        address.setStreet("Gateveien");
        address.setStreetNo("123");
        
        final ContactInformation contactInformation = new ContactInformation();
        contactInformation.setEmail("ola@nordmann.no");
        contactInformation.setMobilePhone("12345678");
        
        final Date fra = Date.from(LocalDateTime.of(2016, 1, 1, 8, 0).atZone(ZoneId.systemDefault()).toInstant());
        final Date til = Date.from(LocalDateTime.of(2017, 1, 1, 8, 0).atZone(ZoneId.systemDefault()).toInstant());
        
        final EmploymentPeriod employmentPeriod = new EmploymentPeriod();
        employmentPeriod.setStartDate(fra);
        employmentPeriod.setEndDate(til);
        
        final Integer salary = 123;
        
        final Employee employee = new FullTimeEmployee();
        employee.setFirstName("Ola");
        employee.setLastName("Nordmann");
        employee.setDateOfBirth(date);
        employee.setAddress(address);
        employee.setContactInformation(contactInformation);
        employee.setEmploymentPeriod(employmentPeriod);
        ((FullTimeEmployee) employee).setSalary(salary);
        
        EmployeeVO employeeVO = EmployeeMapper.map(employee);
        assertEquals(employeeVO.getFirstName(), employee.getFirstName());
        assertEquals(employeeVO.getLastName(), employee.getLastName());
        assertEquals(employeeVO.getDateOfBirth(), employee.getDateOfBirth());
        assertEquals(employeeVO.getStreet(), address.getStreet());
        assertEquals(employeeVO.getStreetNo(), address.getStreetNo());
        assertEquals(employeeVO.getPostalCode(), address.getPostalCode());
        assertEquals(employeeVO.getCity(), address.getCity());
        assertEquals(employeeVO.getEmail(), contactInformation.getEmail());
        assertEquals(employeeVO.getMobilePhone(), contactInformation.getMobilePhone());
        assertEquals(employeeVO.getStartDate(), fra);
        assertEquals(employeeVO.getEndDate(), til);
        assertEquals(employeeVO.getSalary(), salary);
    }
    
    @Test
    public void testMap_Employee2() {
        final Integer salary = 123;
        
        final Employee employee = new FullTimeEmployee();
        ((FullTimeEmployee) employee).setSalary(salary);
        
        final EmployeeVO employeeVO = EmployeeMapper.map(employee);
        assertEquals(employeeVO.getSalary(), salary);
        assertEquals(employeeVO.getType(), EmployeeType.FULL_TIME_EMPLOYEE);
        assertThat(employeeVO.getType(), is(not(nullValue())));
    }
    
    @Test
    public void testMap_Employee3() {
        final Integer salary = 123;
        
        final Employee employee = new PartTimeEmployee();
        ((PartTimeEmployee) employee).setHourlyWage(salary);
        
        final EmployeeVO employeeVO = EmployeeMapper.map(employee);
        assertEquals(employeeVO.getSalary(), salary);
        assertEquals(employeeVO.getType(), EmployeeType.PART_TIME_EMPLOYEE);
        assertThat(employeeVO.getType(), is(not(nullValue())));
    }
    
    @Test
    public void testFullTimeEmployee() {
        final Integer salary = 123;
        
        final FullTimeEmployee employee = new FullTimeEmployee();
        employee.setSalary(salary);
        
        final EmployeeVO employeeVO = EmployeeMapper.map(employee);
        
        assertEquals(employeeVO.getSalary(), employee.getSalary());
        assertEquals(employeeVO.getType(), EmployeeType.FULL_TIME_EMPLOYEE);
        assertThat(employeeVO.getType(), not(EmployeeType.PART_TIME_EMPLOYEE));
        assertThat(employeeVO.getType(), is(not(nullValue())));
    }
    
    @Test
    public void testPartTimeEmployee() {
        final Integer salary = 123;
        
        final PartTimeEmployee employee = new PartTimeEmployee();
        employee.setHourlyWage(salary);
        
        EmployeeVO employeeVO = EmployeeMapper.map(employee);
        
        assertEquals(employeeVO.getSalary(), employee.getHourlyWage());
        assertEquals(employeeVO.getType(), EmployeeType.PART_TIME_EMPLOYEE);
        assertThat(employeeVO.getType(), not(EmployeeType.FULL_TIME_EMPLOYEE));
        assertThat(employeeVO.getType(), is(not(nullValue())));
    }

    @Test
    public void testMap_EmployeeVO() {
        final EmployeeVO employeeVO = new EmployeeVO();
        employeeVO.setCity("Bergen");
        employeeVO.setDateOfBirth(new Date());
        employeeVO.setEmail("ola@nordmann.no");
        employeeVO.setEndDate(new Date());
        employeeVO.setFirstName("Ola");
        employeeVO.setLastName("Nordmann");
        employeeVO.setMobilePhone("12345678");
        employeeVO.setPostalCode("5006");
        employeeVO.setSalary(123);
        employeeVO.setStartDate(new Date());
        employeeVO.setStreet("Gateveien");
        employeeVO.setStreetNo("123");
        employeeVO.setType(EmployeeType.FULL_TIME_EMPLOYEE);
        
        final Employee employee = EmployeeMapper.map(employeeVO);
        
        assertEquals(employee.getAddress().getCity(), employeeVO.getCity());
        assertEquals(employee.getAddress().getPostalCode(), employeeVO.getPostalCode());
        assertEquals(employee.getAddress().getStreet(), employeeVO.getStreet());
        assertEquals(employee.getAddress().getStreetNo(), employeeVO.getStreetNo());
        assertEquals(employee.getContactInformation().getEmail(), employeeVO.getEmail());
        assertEquals(employee.getContactInformation().getMobilePhone(), employeeVO.getMobilePhone());
        assertEquals(employee.getDateOfBirth(), employeeVO.getDateOfBirth());
        assertEquals(employee.getEmploymentPeriod().getStartDate(), employeeVO.getStartDate());
        assertEquals(employee.getEmploymentPeriod().getEndDate(), employeeVO.getEndDate());
        assertEquals(employee.getFirstName(), employeeVO.getFirstName());
        assertEquals(employee.getLastName(), employeeVO.getLastName());
        
        final FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) employee;
        assertEquals(fullTimeEmployee.getSalary(), employeeVO.getSalary());
    }
    
    @Test
    public void testMap_EmployeeVO2() {
        final EmployeeVO employeeVO = new EmployeeVO();
        employeeVO.setCity("Bergen");
        employeeVO.setDateOfBirth(new Date());
        employeeVO.setEmail("ola@nordmann.no");
        employeeVO.setEndDate(new Date());
        employeeVO.setFirstName("Ola");
        employeeVO.setLastName("Nordmann");
        employeeVO.setMobilePhone("12345678");
        employeeVO.setPostalCode("5006");
        employeeVO.setSalary(123);
        employeeVO.setStartDate(new Date());
        employeeVO.setStreet("Gateveien");
        employeeVO.setStreetNo("123");
        employeeVO.setType(EmployeeType.PART_TIME_EMPLOYEE);
        
        final Employee employee = EmployeeMapper.map(employeeVO);
        
        assertEquals(employee.getAddress().getCity(), employeeVO.getCity());
        assertEquals(employee.getAddress().getPostalCode(), employeeVO.getPostalCode());
        assertEquals(employee.getAddress().getStreet(), employeeVO.getStreet());
        assertEquals(employee.getAddress().getStreetNo(), employeeVO.getStreetNo());
        assertEquals(employee.getContactInformation().getEmail(), employeeVO.getEmail());
        assertEquals(employee.getContactInformation().getMobilePhone(), employeeVO.getMobilePhone());
        assertEquals(employee.getDateOfBirth(), employeeVO.getDateOfBirth());
        assertEquals(employee.getEmploymentPeriod().getStartDate(), employeeVO.getStartDate());
        assertEquals(employee.getEmploymentPeriod().getEndDate(), employeeVO.getEndDate());
        assertEquals(employee.getFirstName(), employeeVO.getFirstName());
        assertEquals(employee.getLastName(), employeeVO.getLastName());
        
        final PartTimeEmployee partTimeEmployee = (PartTimeEmployee) employee;
        assertEquals(partTimeEmployee.getHourlyWage(), employeeVO.getSalary());
    }
    
}
