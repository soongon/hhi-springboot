package com.hhi.springhhi.controller;

import com.hhi.springhhi.domain.Ship;
import com.hhi.springhhi.dto.ShipCreateRequest;
import com.hhi.springhhi.dto.ShipResponse;
import com.hhi.springhhi.dto.ShipUpdateRequest;
import com.hhi.springhhi.service.ShipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShipController {
    private static final Logger log = LoggerFactory.getLogger(ShipController.class);

    private final ShipService shipService;

    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping("/ships")
    public List<ShipResponse> getAllShips() {
        log.debug("전체보기 컨트롤러 시작..");
        return shipService.getAllShips();
    }

    @GetMapping("/ships/{shipId}")
    public ShipResponse getShipById(@PathVariable String shipId) {
        return shipService.getShipById(shipId);
    }

    @PostMapping("/ships")
    public ShipResponse registShip(@RequestBody ShipCreateRequest shipCreateRequest) {

        return shipService.registShip(shipCreateRequest);
    }

    @PutMapping("/ships/{shipId}")
    public ShipResponse modifyShip(
            @PathVariable String shipId,
            @RequestBody ShipUpdateRequest request) {
        return shipService.modifyShip(shipId, request);
    }
}
