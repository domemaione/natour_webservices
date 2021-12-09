package com.ingsoftw.v01.natour_webservices.repository;

import com.ingsoftw.v01.natour_webservices.model.Coordinata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinataRepository extends JpaRepository<Coordinata, Long> {
}
