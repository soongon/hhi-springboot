package com.hhi.springhhi.controller;

import com.hhi.springhhi.dto.ShipCreateRequest;
import com.hhi.springhhi.service.ShipService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ships")
public class ShipController {

    private final ShipService shipService;

    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping()
    public List<ShipCreateRequest> getAllShips() {
        return shipService.getAllShips();
    }

    @GetMapping("/{shipId}")
    public ShipCreateRequest getShipById(@PathVariable String shipId) {
        return shipService.getShipById(shipId);
    }

    @PostMapping()
    public String registShip(@RequestBody ShipCreateRequest shipCreateRequest) {

        return shipService.registShip(shipCreateRequest);
    }

    @PutMapping("/{shipId}")
    public String modifyShip(
            @PathVariable String shipId,
            @RequestBody ShipCreateRequest shipCreateRequest) {
        // ship 데이터를 db 에 인서트한다.
        shipCreateRequest.setId(shipId);
        System.out.println(shipCreateRequest);
        return shipCreateRequest.toString();
    }
}
