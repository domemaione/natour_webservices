package com.ingsoftw.v01.natour_webservices.repository;

import com.ingsoftw.v01.natour_webservices.model.Itinerario;
import com.ingsoftw.v01.natour_webservices.model.Valutazione;
import com.ingsoftw.v01.natour_webservices.model.ValutazionePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ValutazioneRepository extends JpaRepository<Valutazione, ValutazionePK> {

   // public List<Valutazione> findByValutazionePKItinerario(Itinerario itinerario);

}