package component;

import dagger.Component;
import module.HelloWorldModule;
import resource.HelloWorldResource;

import javax.inject.Singleton;

@Singleton
@Component(modules = HelloWorldModule.class)
public interface HelloWorldComponent {

    HelloWorldResource inject(HelloWorldResource resource);
}