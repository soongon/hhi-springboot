package com.hhi.springhhi.repository;

import com.hhi.springhhi.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlockRepository extends JpaRepository<Block, Long> {
    List<Block> findByParentShipIdOrderByBlockCode(Long ShipId);
    boolean existsByParentShipIdAndBlockCode(Long shipId, String blockCode);
    long countByParentShip_Id(Long shipId);
}
