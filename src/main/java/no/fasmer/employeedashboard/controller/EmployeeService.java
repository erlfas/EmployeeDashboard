package no.fasmer.employeedashboard.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import no.fasmer.employeedashboard.dao.EmployeeDao;
import no.fasmer.employeedashboard.entity.Employee;
import no.fasmer.employeedashboard.utils.EmployeeMapper;
import static no.fasmer.employeedashboard.utils.ExceptionUtils.getRootErrorMessage;
import no.fasmer.employeedashboard.vo.EmployeeVO;

@Model
public class EmployeeService {
    
    @Inject
    private FacesContext facesContext;
    
    @Produces
    @Named
    private EmployeeVO newEmployee;
    
    @Inject
    private EmployeeDao employeeDao;
    
    @Inject
    private List<EmployeeVO> employees; // cf. EmployeeProducer
    
    @Inject
    private Event<EmployeeVO> newEmployeeEvent;
    
    @PostConstruct
    public void initNewEmployee() {
        newEmployee = new EmployeeVO();
    }
    
    public void addNewEmployee() {
        try {
            final Employee employee = EmployeeMapper.map(newEmployee);
            employeeDao.persist(employee);
            
            final FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Done!", "Employee created");
            facesContext.addMessage(null, m);
            initNewEmployee();
            newEmployeeEvent.fire(newEmployee);
        } catch (Exception e) {
            final String errorMessage = getRootErrorMessage(e);
            final FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Error while saving data");
            facesContext.addMessage(null, m);
        }
    }
    
}