package com.cesarmando.website.util;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by Local_admin on 8/2/2017.
 */
public class TomcatProfileCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return !(context.getEnvironment().acceptsProfiles("jetty")
                || context.getEnvironment().acceptsProfiles("undertow"));
    }
}