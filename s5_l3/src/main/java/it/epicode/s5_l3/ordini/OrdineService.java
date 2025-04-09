package it.epicode.s5_l3.ordini;

import it.epicode.s5_l3.menu.Menu;
import it.epicode.s5_l3.menu.MenuService;
import it.epicode.s5_l3.menu.ProdottoMenu;
import it.epicode.s5_l3.ordini.statoOrdine.StatoOrdine;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdineService {
    @Autowired
    private OrdineRepository ordineRepository;
    @Autowired
    private MenuService menuService;

    public void createOrdine(double costoCoperto) {
        Menu menu = menuService.getMenu();

        Ordine ordine = new Ordine();
        ordine.setNumeroCoperti(4);
        ordine.setProdottiMenu(new ArrayList<>(menu.getProdottiMenu()));
        ordine.setStatoOrdine(StatoOrdine.IN_CORSO);
        ordine.setOrarioAcquisizione(LocalTime.now());

        ordineRepository.save(ordine);
        ordine.printOrdine(costoCoperto);
    }

    public List<Ordine> findAll() {
        return ordineRepository.findAll();
    }
}

