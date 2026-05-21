package com.hhi.springhhi.repository;

import com.hhi.springhhi.domain.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ShipRepository extends JpaRepository<Ship, Long> {

    Optional<Ship> findByShipNumber(String shipNumber);
}
