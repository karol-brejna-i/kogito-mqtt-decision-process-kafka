package org.demo.rsotf;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Brydzia {

    @Incoming("jeden")
    @Outgoing("kogito_incoming_stream")
    public String deserialize(byte[] payload) {
        return new String(payload);
    }
}
