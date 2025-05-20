package com;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class MainResource {
    public static void main(String... args) {
        Quarkus.run(args);
    }
}
