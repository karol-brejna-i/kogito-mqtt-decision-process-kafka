package org.demo.rsotf;

import org.demo.rsotf.model.*;
import org.demo.rsotf.services.StoreLocationService;
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
    private DataStore<CustomerLocation> customerLocations;
    private DataStore<CustomerFocus> customerFocus;

    // Number of "steps" in the same department to treat a customer as focused
    private int requiredNumberOfSteps = 3;

    @Inject
    private StoreLocationService storeLocationService;

    public CustomerUnit() {
        this(DataSource.createSingleton(),
                DataSource.createStore(),
                DataSource.createStore(),
                DataSource.createStore(),
                CustomerUnit.getDepartments());
        System.out.println("Creating data sources");
    }

    public CustomerUnit(
            SingletonStore<CustomerMovement> customerMovements,
            DataStore<CustomerLocation> customerLocations,
            DataStore<CustomerFocus> customerFocus,
            DataStore<Department> departmentDataStore,
            List<Department> departments) {

        this.customerMovements = customerMovements;
        this.customerLocations = customerLocations;
        this.departmentDataStore = departmentDataStore;

        for (Department d : departments) {
            departmentDataStore.add(d);
        }

        this.storeLocationService = new StoreLocationService();
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

    public DataStore<CustomerLocation> getCustomerLocations() {
        return customerLocations;
    }

    public void setCustomerLocations(DataStore<CustomerLocation> customerLocations) {
        this.customerLocations = customerLocations;
    }

    public SingletonStore<CustomerMovement> getCustomerMovements() {
        return customerMovements;
    }

    public void setCustomerMovements(SingletonStore<CustomerMovement> customerMovements) {
        this.customerMovements = customerMovements;
    }

    public StoreLocationService getStoreLocationService() {
        return storeLocationService;
    }

    public void setStoreLocationService(StoreLocationService storeLocationService) {
        this.storeLocationService = storeLocationService;
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
}