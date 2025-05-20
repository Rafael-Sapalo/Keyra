package com;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class MainResource {
    public static void main(String... args) {
        Quarkus.run(KeyraApp.class, args);
    }

    public  static class KeyraApp implements QuarkusApplication {
        @Override
        public int run(String... args) throws Exception {
            System.out.println("🚀 Keyra is starting...");
            Quarkus.waitForExit();
            return 0;
        }
    }
}
