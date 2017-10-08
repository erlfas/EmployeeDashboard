package no.fasmer.employeedashboard.dao;

import java.util.List;
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
    
    public List<Employee> getAllFullTimeEmployees() {
        return em.createNamedQuery("findAllFullTimeEmployees").getResultList();
    }
    
    public List<Employee> getAllPartTimeEmployees() {
        return em.createNamedQuery("findAllPartTimeEmployees").getResultList();
    }
    
}
