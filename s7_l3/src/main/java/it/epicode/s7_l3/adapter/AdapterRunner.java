package it.epicode.s7_l3.adapter;

import it.epicode.s7_l3.adapter.adapters.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Order(1)
public class AdapterRunner implements CommandLineRunner{
    @Override
    public void run(String... args) throws Exception {
        System.out.println("---- Adapter Runner ----");

        Info info = new Info("Mario", "Rossi", new Date(1990, 1, 1));
        UserData userData = new UserData();
        User user = new User(info);

        /*userData.getData(user);
        System.out.println("Nome Completo: " + userData.getNomeCompleto());
        System.out.println("Età: " + userData.getEta());*/

        StampaUtente.print(user);


    }
}
