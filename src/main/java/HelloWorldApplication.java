import component.DaggerHelloWorldComponent;
import component.HelloWorldComponent;
import config.HelloWorldConfiguration;
import entity.User;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import module.HelloWorldModule;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import resource.HelloWorldResource;

import java.io.FileInputStream;
import java.util.Properties;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    private HelloWorldComponent component;

    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();
        properties.load(new FileInputStream("config.properties"));

        /*args = new String[]{"server"};

        System.out.println(args[0]);

        properties.setProperty("example.yml", args[0]);*/

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