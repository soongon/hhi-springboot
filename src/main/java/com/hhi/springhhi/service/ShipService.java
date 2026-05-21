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
    public Ship registShip(ShipCreateRequest request) {

        // Ship 엔티티를 만들고.. save() 함수를 호출한다.
        Ship ship = new Ship(
                request.getShipNumber(), request.getName(),
                request.getType(), request.getLength(),
                request.getWeight(), request.getStatus()
        );
        shipRepository.save(ship);  // 이순간 DB에 insert가 이루어짐 (커밋도 완료)

        return ship;
    }

    public List<Ship> getAllShips() {

        return shipRepository.findAll();
    }

    public ShipCreateRequest getShipById(String shipId) {
        return null;
    }

    public ShipCreateRequest modifyShip(String shipId) {

        return null;
    }
}
