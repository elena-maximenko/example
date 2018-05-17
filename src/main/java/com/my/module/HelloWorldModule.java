package com.my.module;

import com.my.config.HelloWorldConfiguration;
import dagger.Module;
import dagger.Provides;
import com.my.entity.User;

import javax.inject.Singleton;

@Module
public class HelloWorldModule {

    private HelloWorldConfiguration helloWorldConfiguration;

    public HelloWorldModule(HelloWorldConfiguration configuration) {
        this.helloWorldConfiguration = configuration;
    }

    @Provides
    @Singleton
    public User provideUser() {
        return helloWorldConfiguration.getUser();
    }

}