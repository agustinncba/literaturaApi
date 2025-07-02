package com.literaturaApi.literaturaApi;

import com.literaturaApi.literaturaApi.principal.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraturaApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LiteraturaApiApplication.class, args);
    }

    @Autowired
    Principal principal;

    @Override
    public void run(String... args) throws Exception {
        principal.mostrarMenu();
    }
}
