package ru.otus.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.otus.springboot.controller.AppController;

@Component
class AppRunner implements CommandLineRunner {

    private final AppController appController;

    public AppRunner(AppController appController) {
        this.appController = appController;
    }

    @Override
    public void run(String... args) {
        appController.executeTesting();
    }
}
