package it.epicode.s5_l2.menu;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MenuRunner implements CommandLineRunner {
    private final Menu menu;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("---- Menù ----");
        menu.printMenu();

    }
}
