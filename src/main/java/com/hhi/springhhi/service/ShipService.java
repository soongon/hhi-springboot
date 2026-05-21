package com.hhi.springhhi.service;

import com.hhi.springhhi.domain.Ship;
import com.hhi.springhhi.dto.ShipCreateRequest;
import com.hhi.springhhi.repository.ShipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipService {

    private final ShipRepository shipRepository;

    public ShipService(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    // 배를 등록한다.
    public Ship registShip(ShipCreateRequest shipCreateRequest) {
        return null;
    }

    public List<ShipCreateRequest> getAllShips() {

        return null;
    }

    public ShipCreateRequest getShipById(String shipId) {
        return null;
    }

    public ShipCreateRequest modifyShip(String shipId) {

        return null;
    }
}
