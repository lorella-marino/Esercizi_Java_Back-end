package it.epicode.s5_l4.ordini;


import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdineRepository extends JpaRepository<Ordine, Long> {
    Ordine findByNumeroOrdine(int numeroOrdine);
}