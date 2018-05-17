package com.my.component;

import dagger.Component;
import com.my.module.HelloWorldModule;
import com.my.resource.HelloWorldResource;

import javax.inject.Singleton;

@Singleton
@Component(modules = HelloWorldModule.class)
public interface HelloWorldComponent {

    HelloWorldResource inject(HelloWorldResource resource);
}