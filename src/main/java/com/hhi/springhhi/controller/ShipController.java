package com.hhi.springhhi.controller;

import com.hhi.springhhi.dto.Ship;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShipController {

    @GetMapping("/ships")
    public List<Ship> getAllShips() {
        // db에서 배목록을 전체를 가져와야 하나.. 지금은 슈도코드로 작성..
        List<Ship> ships = List.of(
                new Ship("22srew22", 1, "현대조선호", "container", 322344, 56666, "in progress"),
                new Ship("fdfsfds", 2, "현대조선호2", "container", 322344, 56666, "in progress"),
                new Ship("22srewerwrw22", 3, "현대조선호3", "container", 322344, 56666, "in progress")
        );
        return ships;
    }

    @GetMapping("/ships/{shipId}")
    public Ship getShipById(@PathVariable String shipId) {
        // DB에서 shipId에 해당하는 배데이터를 갖고 온다.
        // select * from ships where shipId=shipId
        Ship theShip = new Ship("22srew22", 1, "현대조선호", "container", 322344, 56666, "in progress");
        return theShip;
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
