package no.fasmer.employeedashboard.producers;

import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import no.fasmer.employeedashboard.dao.EmployeeDao;
import no.fasmer.employeedashboard.entity.Employee;
import no.fasmer.employeedashboard.utils.EmployeeMapper;
import no.fasmer.employeedashboard.vo.EmployeeVO;

@RequestScoped
public class EmployeeProducer {
    
    @Inject
    private EmployeeDao employeeDao;
    
    private List<Employee> employees;
    
    @PostConstruct
    public void retrieveAllEmployees() {
        employees = employeeDao.findAll();
    }
    
    @Produces
    @Named
    public List<EmployeeVO> getEmployees() {
        return employees.stream().map(EmployeeMapper::map).collect(Collectors.toList());
    }
    
    public void onListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final EmployeeVO member) {
        retrieveAllEmployees();
    }
    
    public void onListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Employee member) {
        retrieveAllEmployees();
    }
    
}