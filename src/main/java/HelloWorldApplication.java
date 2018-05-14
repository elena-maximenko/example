import component.DaggerHelloWorldComponent;
import component.HelloWorldComponent;
import config.HelloWorldConfiguration;
import entity.User;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import module.HelloWorldModule;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import resource.HelloWorldResource;

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