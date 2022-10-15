package com.ingsoftw.v01.natour_webservices.repository;

import com.ingsoftw.v01.natour_webservices.model.Itinerario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//DAO
@Repository
public interface ItinerarioRepository extends JpaRepository<Itinerario, Long> { //qui ho importato tutte le funzioni già implementate dalla jpa repository
    
    //public List<Itinerario> findByNome(String nome); //estrae itinerari in base al nome
}
