package org.demo.rsotf;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Brydzia {
    private static final Logger LOG = Logger.getLogger(Brydzia.class);

    @Incoming("source")
    @Outgoing("kogito_incoming_stream")
    public String deserialize(byte[] payload) {
        return new String(payload);
    }
}
