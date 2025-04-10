package it.epicode.s5_l4.pizze;


import org.springframework.data.jpa.repository.JpaRepository;

import javax.lang.model.element.Name;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    Pizza findById (int id);
}