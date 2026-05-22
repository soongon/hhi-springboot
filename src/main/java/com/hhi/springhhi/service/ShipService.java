package com.hhi.springhhi.service;

import com.hhi.springhhi.domain.Ship;
import com.hhi.springhhi.domain.ShipStatus;
import com.hhi.springhhi.domain.ShipType;
import com.hhi.springhhi.dto.ShipCreateRequest;
import com.hhi.springhhi.dto.ShipResponse;
import com.hhi.springhhi.dto.ShipUpdateRequest;
import com.hhi.springhhi.exception.HhiShipException;
import com.hhi.springhhi.repository.ShipRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ShipService {

    private final ShipRepository shipRepository;

    public ShipService(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    // 배를 등록한다.
    public ShipResponse registShip(ShipCreateRequest request) {

        // 호선번호(shipNumber)가 이미 존재하면 막는다. (DB unique 제약 위반 전에 차단)
        shipRepository.findByShipNumber(request.getShipNumber())
                .ifPresent(s -> {
                    throw new HhiShipException("이미 존재하는 호선번호입니다: " + request.getShipNumber());
                });

        // Ship 엔티티를 만들고.. save() 함수를 호출한다.
        Ship ship = new Ship(
                request.getShipNumber(), request.getName(),
                request.getType(), request.getLength(),
                request.getWeight(), request.getStatus()
        );
        shipRepository.save(ship);  // 이순간 DB에 insert가 이루어짐 (커밋도 완료)

        return ShipResponse.from(ship);
    }

    @Transactional(readOnly = true)
    public List<ShipResponse> getAllShips() {

        List<Ship> ships = shipRepository.findAll();
        // ships 을 shipResponse(DTO)로 옮겨담는다.
        return ships.stream()
                .map(ShipResponse::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public ShipResponse getShipById(Long shipId) {
        Ship ship = shipRepository.findById(shipId)
                .orElseThrow(() -> new HhiShipException("배를 찾을수 없어요"));

        return ShipResponse.from(ship);
    }

    public ShipResponse modifyShip(Long shipId, ShipUpdateRequest request) {

        Ship ship = shipRepository.findById(shipId)
                        .orElseThrow(() -> new HhiShipException("배가 없어요"));

        ship.setName(request.getName());
        ship.setType(request.getType());
        ship.setLength(request.getLength());
        ship.setWeight(request.getWeight());
        ship.setStatus(request.getStatus());
        return ShipResponse.from(ship);
    }
}
