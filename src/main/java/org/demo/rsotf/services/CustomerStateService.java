package org.demo.rsotf.services;

import org.demo.rsotf.model.CustomerMovement;
import org.demo.rsotf.model.CustomerState;
import org.demo.rsotf.model.CustomerStateType;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class CustomerStateService {
    private static final Logger LOG = Logger.getLogger(CustomerStateService.class);

    private static Map<String, CustomerState> store = new HashMap<>();

    public CustomerStateService() {
    }

    public static CustomerState locationFromMovement(CustomerStateType state, CustomerMovement m) {
        return new CustomerState(m.getId(), state, m.getX(), m.getY(), m.getTs(), m.getSeenIn(), m.getTs());
    }

    public boolean storeLocation(CustomerState location) {
        CustomerState stored = CustomerStateService.store.put(location.getId(), location);
        return true;
    }

    public CustomerState retrieveLocation(CustomerMovement movement) {
        CustomerState retrieved = CustomerStateService.store.getOrDefault(
                movement.getId(), locationFromMovement(CustomerStateType.UNKNOWN, movement));

        if (retrieved == null) {
            LOG.error("Something went terribly wrong...");
        }
        return retrieved;
    }
}
