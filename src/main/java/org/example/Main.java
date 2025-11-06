package org.example;

import com.google.inject.Guice;
import com.google.inject.Injector;
import jakarta.inject.Inject;

public class Main {

    @Inject
    public App app;

    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        Main mainInstance = injector.getInstance(Main.class);
        mainInstance.app.run();
    }
}


