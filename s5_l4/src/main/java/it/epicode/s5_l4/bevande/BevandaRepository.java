package it.epicode.s5_l4.bevande;


import org.springframework.data.jpa.repository.JpaRepository;

public interface BevandaRepository extends JpaRepository<Bevanda, Long> {
}