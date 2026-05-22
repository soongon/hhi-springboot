package com.hhi.springhhi.service;

import com.hhi.springhhi.domain.Ship;
import com.hhi.springhhi.repository.BlockRepository;
import com.hhi.springhhi.repository.ShipRepository;
import org.springframework.stereotype.Service;

@Service
public class BlockService {

    private final ShipRepository shipRepository;
    private final BlockRepository blockRepository;

    public BlockService(ShipRepository shipRepository, BlockRepository blockRepository) {
        this.shipRepository = shipRepository;
        this.blockRepository = blockRepository;
    }

    public List<BlockResponse> getBlocksByShipId(String shipId) {
        Ship parentShip = shipRepository.findById(Long.parseLong(shipId)).get();
        // 모선에 포함된 모든 블럭을 가져온다.
        return null;
    }
}
