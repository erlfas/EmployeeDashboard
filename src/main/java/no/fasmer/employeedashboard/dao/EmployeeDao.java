package no.fasmer.employeedashboard.dao;

import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import no.fasmer.employeedashboard.entity.Employee;

@Stateless
public class EmployeeDao extends AbstractDao<Employee> {
    
    @Inject
    private Logger logger;
    
    public EmployeeDao() {
        super(Employee.class);
    }
    
}
