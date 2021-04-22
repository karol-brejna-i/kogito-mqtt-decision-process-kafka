package org.demo.rsotf.services;

import org.demo.rsotf.model.CustomerLocation;
import org.demo.rsotf.model.CustomerMovement;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class StoreLocationService {

    private static Map<String, CustomerLocation> store = new HashMap<>();

    public StoreLocationService() {
    }

    public static CustomerLocation locationFromMovement(CustomerMovement m) {
        return new CustomerLocation(m.getId(), m.getX(), m.getY(), m.getTs(), m.getSeenIn(), m.getTs(), 1);
    }

    public boolean storeLocation(CustomerLocation location) {
        CustomerLocation stored = StoreLocationService.store.put(location.getId(), location);
        return true;
    }

    public CustomerLocation retrieveLocation(CustomerMovement movement) {
        CustomerLocation retrieved = StoreLocationService.store.getOrDefault(movement.getId(), locationFromMovement(movement));

        if (retrieved == null) {
            System.out.println("Something went terribly wrong...");
        }
        return retrieved;
    }
}
