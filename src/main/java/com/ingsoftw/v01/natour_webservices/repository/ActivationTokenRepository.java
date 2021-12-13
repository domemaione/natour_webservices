package com.ingsoftw.v01.natour_webservices.repository;

import com.ingsoftw.v01.natour_webservices.model.ActivationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivationTokenRepository extends JpaRepository<ActivationToken, Long> {
}
