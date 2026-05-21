package com.hhi.springhhi.repository;

import com.hhi.springhhi.domain.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ShipRepository extends JpaRepository<Ship, Long> {

    @Override
    List<Ship> findAll();

    @Override
    Optional<Ship> findById(Long aLong);

    @Override
    void deleteById(Long aLong);

    @Override
    Ship save(Ship entity);  // upsert

    Optional<Ship> findByShipNumber(String shipNumber);
}
