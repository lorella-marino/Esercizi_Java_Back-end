package it.epicode.s5_l3.bevande;


import org.springframework.data.jpa.repository.JpaRepository;

public interface BevandaRepository extends JpaRepository<Bevanda, Long> {
}