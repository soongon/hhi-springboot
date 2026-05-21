package com.hhi.springhhi.service;

import com.hhi.springhhi.domain.Ship;
import com.hhi.springhhi.domain.ShipStatus;
import com.hhi.springhhi.domain.ShipType;
import com.hhi.springhhi.dto.ShipCreateRequest;
import com.hhi.springhhi.dto.ShipUpdateRequest;
import com.hhi.springhhi.exception.HhiShipException;
import com.hhi.springhhi.repository.ShipRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
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

    @Transactional(readOnly = true)
    public List<Ship> getAllShips() {

        return shipRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Ship getShipById(String shipId) {
        Optional<Ship> theShip = shipRepository.findById(Long.parseLong(shipId));
        // 찾으려는 배가 없을때는 예외처리로 처리한다. TODO
        return theShip.orElseThrow(
                () ->  new IllegalArgumentException("배를 찾을수 없어요"));
    }

    public Ship modifyShip(String shipId, ShipUpdateRequest request) {

        Ship ship = shipRepository.findById(Long.parseLong(shipId))
                        .orElseThrow(() -> new HhiShipException("배가 없어요"));

        ship.setName(request.getName());
        ship.setType(request.getType());
        ship.setLength(request.getLength());
        ship.setWeight(request.getWeight());
        ship.setStatus(request.getStatus());
        return ship;
    }
}
