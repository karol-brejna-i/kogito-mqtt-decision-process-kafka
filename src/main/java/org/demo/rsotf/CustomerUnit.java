package org.demo.rsotf;

import org.demo.rsotf.model.*;
import org.demo.rsotf.services.CustomerStateService;
import org.kie.kogito.rules.DataSource;
import org.kie.kogito.rules.DataStore;
import org.kie.kogito.rules.RuleUnitData;
import org.kie.kogito.rules.SingletonStore;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class CustomerUnit implements RuleUnitData {
    private final DataStore<Department> departmentDataStore;
    private SingletonStore<CustomerMovement> customerMovements;
    private SingletonStore<CustomerState> customerState;
    private DataStore<CustomerFocus> customerFocus;
    private SingletonStore<CustomerState> browsingCustomer;

    // Number of "steps" in the same department to treat a customer as focused
    private int requiredNumberOfSteps = 3;

    @Inject
    private CustomerStateService customerStateService;

    public CustomerUnit() {
        this(DataSource.createSingleton(),
                DataSource.createSingleton(),
                DataSource.createStore(),
                DataSource.createStore(),
                CustomerUnit.getDepartments(), DataSource.createSingleton());
    }

    public CustomerUnit(
            SingletonStore<CustomerMovement> customerMovements,
            SingletonStore<CustomerState> customerState,
            DataStore<CustomerFocus> customerFocus,
            DataStore<Department> departmentDataStore,
            List<Department> departments, SingletonStore<CustomerState> browsingCustomer) {

        this.customerMovements = customerMovements;
        this.customerState = customerState;
        this.departmentDataStore = departmentDataStore;
        this.browsingCustomer = browsingCustomer;

        for (Department d : departments) {
            departmentDataStore.add(d);
        }

        this.customerStateService = new CustomerStateService();
    }

    private static List<Department> getDepartments() {
        List<Department> departments = new LinkedList<>();
        departments.add(new Department("Women", new Area(444, 443,  666, 879), ""));
        departments.add(new Department("Boys",  new Area(672, 443,  992, 658), ""));
        departments.add(new Department("Girls", new Area(998, 443, 1317, 658), ""));
        departments.add(new Department("Men",   new Area(672, 664, 1317, 879), ""));
        departments.add(new Department("Sports",new Area(614, 984, 1186, 1292), ""));
        return departments;
    }

    public SingletonStore<CustomerState> getCustomerState() {
        return customerState;
    }

    public void setCustomerState(SingletonStore<CustomerState> customerState) {
        this.customerState = customerState;
    }

    public SingletonStore<CustomerMovement> getCustomerMovements() {
        return customerMovements;
    }

    public void setCustomerMovements(SingletonStore<CustomerMovement> customerMovements) {
        this.customerMovements = customerMovements;
    }

    public CustomerStateService getCustomerStateService() {
        return customerStateService;
    }

    public void setCustomerStateService(CustomerStateService customerStateService) {
        this.customerStateService = customerStateService;
    }

    public DataStore<Department> getDepartmentDataStore() {
        return departmentDataStore;
    }

    public DataStore<CustomerFocus> getCustomerFocus() {
        return customerFocus;
    }

    public void setCustomerFocus(DataStore<CustomerFocus> customerFocus) {
        this.customerFocus = customerFocus;
    }

    public int getRequiredNumberOfSteps() {
        return requiredNumberOfSteps;
    }

    public void setRequiredNumberOfSteps(int requiredNumberOfSteps) {
        this.requiredNumberOfSteps = requiredNumberOfSteps;
    }

    public SingletonStore<CustomerState> getBrowsingCustomer() {
        return browsingCustomer;
    }

    public void setBrowsingCustomer(SingletonStore<CustomerState> browsingCustomer) {
        this.browsingCustomer = browsingCustomer;
    }
}
