package com.hhi.springhhi.controller;

import com.hhi.springhhi.dto.Ship;
import com.hhi.springhhi.service.ShipService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShipController {

    private final ShipService shipService;

    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping("/ships")
    public List<Ship> getAllShips() {
        return shipService.getAllShips();
    }

    @GetMapping("/ships/{shipId}")
    public Ship getShipById(@PathVariable String shipId) {
        return shipService.getShipById(shipId);
    }

    @PostMapping("/ships")
    public String registShip(@RequestBody Ship ship) {
        return ship.toString();
    }

    @PutMapping("/ships/{shipId}")
    public String modifyShip(
            @PathVariable String shipId,
            @RequestBody Ship ship) {
        // ship 데이터를 db 에 인서트한다.
        ship.setId(shipId);
        System.out.println(ship);
        return ship.toString();
    }
}
