package com.ingsoftw.v01.natour_webservices.repository;

import com.ingsoftw.v01.natour_webservices.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

    public Optional<Utente> findByEmail(String email); //Optional è un oggetto che può esistere e non, Optional è un classe con i suoi metodi
}
