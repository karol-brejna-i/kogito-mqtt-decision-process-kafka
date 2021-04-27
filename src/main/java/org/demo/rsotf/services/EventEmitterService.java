package org.demo.rsotf.services;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.demo.rsotf.model.CustomerBrowsing;
import org.demo.rsotf.model.CustomerState;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.nio.charset.StandardCharsets;

@ApplicationScoped
public class EventEmitterService {
    private static final Logger LOG = Logger.getLogger(EventEmitterService.class);

    @Inject
    @Channel("sink")
    Emitter<byte[]> emitter;

    ObjectMapper mapper;

    public EventEmitterService() {
        this.mapper = new ObjectMapper();
        this.mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public void publish(CustomerState payload) {
        LOG.info("Emitting payload: " + payload);
        CustomerBrowsing message = CustomerBrowsing.fromCustomerState(payload);
        String json = null;
        try {
            json = mapper.writeValueAsString(message);
            LOG.debug("Marshalled payload: " + json);
            emitter.send(json.getBytes(StandardCharsets.UTF_8));
        } catch (JsonProcessingException e) {
            LOG.error("Failed to marshall the payload!", e);
        }
    }
}
