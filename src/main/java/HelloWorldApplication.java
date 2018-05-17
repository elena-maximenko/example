package com.my;

import com.my.component.DaggerHelloWorldComponent;
import com.my.component.HelloWorldComponent;
import com.my.config.HelloWorldConfiguration;
import com.my.entity.User;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import com.my.module.HelloWorldModule;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import com.my.resource.HelloWorldResource;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    private HelloWorldComponent component;

    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public void run(final HelloWorldConfiguration configuration,
                    Environment environment) {

        environment.jersey().register(new AbstractBinder() {

            @Override
            protected void configure() {
                bind(configuration.getUser()).to(User.class);
            }
        });

        component = DaggerHelloWorldComponent.builder().helloWorldModule(new HelloWorldModule(configuration)).build();
        environment.jersey().register(component.inject(new HelloWorldResource()));
    }
}