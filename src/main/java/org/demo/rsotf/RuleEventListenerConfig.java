package org.demo.rsotf;

import org.drools.core.config.DefaultRuleEventListenerConfig;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;

import javax.enterprise.context.ApplicationScoped;

// XXX TODO: uncomment (use ApplicationScoped) to turn on rules debugging info
@ApplicationScoped
public class RuleEventListenerConfig extends DefaultRuleEventListenerConfig {
    public RuleEventListenerConfig() {
        super(new DebugRuleRuntimeEventListener());
    }
}
