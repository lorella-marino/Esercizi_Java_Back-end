package it.epicode.s5_l2.menu;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RigaMenu{
    String descrizioneRiga();
    double getPrezzo();
}
