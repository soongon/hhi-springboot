package com.hhi.springhhi.repository;

import com.hhi.springhhi.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepository extends JpaRepository<Block, Long> {
}
