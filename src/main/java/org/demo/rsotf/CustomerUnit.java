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
        departments.add(new Department("Boy's",   new Area(0.10, 0.20,  1.70, 8.00), ""));
        departments.add(new Department("Girl's",  new Area(0.10, 8.10,  4.20, 13.05), ""));
        departments.add(new Department("Women's", new Area(4.30, 8.10,  15.00, 13.05), ""));
        departments.add(new Department("Men's",   new Area(4.30, 0.20,  13.70, 5.50), ""));
        departments.add(new Department("Sport",  new Area(15.10, 8.10,  18.00, 13.05), ""));
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
