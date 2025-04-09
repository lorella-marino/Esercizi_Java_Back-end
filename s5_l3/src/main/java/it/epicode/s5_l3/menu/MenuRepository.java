package it.epicode.s5_l3.menu;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    @Query("SELECT m FROM Menu m LEFT JOIN FETCH m.prodottiMenu")
    Menu findMenuWithProducts();
}