package com.example.resources;

import com.codahale.metrics.MetricRegistry;
import com.example.views.UsersView;
import com.google.common.collect.ImmutableList;
import com.sun.jersey.api.core.DefaultResourceConfig;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.LowLevelAppDescriptor;
import io.dropwizard.logging.LoggingFactory;
import io.dropwizard.views.ViewMessageBodyWriter;
import io.dropwizard.views.ViewRenderer;
import io.dropwizard.views.mustache.MustacheViewRenderer;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UserResourceTests extends JerseyTest {

    static {
        LoggingFactory.bootstrap();
    }

    @Override
    protected AppDescriptor configure() {
        final DefaultResourceConfig config = new DefaultResourceConfig();
        final ViewRenderer renderer = new MustacheViewRenderer();
        config.getSingletons().add(new ViewMessageBodyWriter(new MetricRegistry(), ImmutableList.of(renderer)));
        config.getSingletons().add(new UserResource());
        return new LowLevelAppDescriptor.Builder(config).build();
    }

    @Test
    public void getAll() throws Exception {
        final String response = client().resource(getBaseURI() + "user").get(String.class);
        assertTrue(response.contains("user1"));
        assertTrue(response.contains("user2"));
    }
}
