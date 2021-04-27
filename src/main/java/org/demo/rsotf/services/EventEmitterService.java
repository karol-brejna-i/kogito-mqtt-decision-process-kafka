package org.demo.rsotf.services;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.demo.rsotf.model.CustomerBrowsing;
import org.demo.rsotf.model.CustomerState;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.nio.charset.StandardCharsets;

@ApplicationScoped
public class EventEmitterService {

    @Inject
    @Channel("sink")
    Emitter<byte[]> emitter;

    ObjectMapper mapper;

    public EventEmitterService() {
        this.mapper = new ObjectMapper();
        this.mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public void publish(CustomerState payload) {
        System.out.println("Emitting payload: " + payload);
        CustomerBrowsing message = CustomerBrowsing.fromCustomerState(payload);
        String json = null;
        try {
            json = mapper.writeValueAsString(message);
            System.out.println("Marshalled payload: " + json);
            emitter.send(json.getBytes(StandardCharsets.UTF_8));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.out.println("Failed to marshall the payload!");
        }
    }

}
