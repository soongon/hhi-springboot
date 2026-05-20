package com.hhi.springhhi.service;

import com.hhi.springhhi.dto.Ship;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipService {

    public List<Ship> getAllShips() {
        // 어쩌구 저쩌구해서 어쨌거나 배 전체 목록을 확보.. 반환해준다.
        // db에서 배목록을 전체를 가져와야 하나.. 지금은 슈도코드로 작성..
        List<Ship> ships = List.of(
                new Ship("22srew22", 1, "현대조선호1", "container", 322344, 56666, "in progress"),
                new Ship("fdfsfds", 2, "현대조선호2", "container", 322344, 56666, "in progress"),
                new Ship("22srewerwrw22", 3, "현대조선호3", "container", 322344, 56666, "in progress")
        );
        return ships;
    }

    public Ship getShipById(String shipId) {
        // DB에서 shipId에 해당하는 배데이터를 갖고 온다.
        // select * from ships where shipId=shipId
        return new Ship("22srew22", 1, "현대조선호", "container", 322344, 56666, "in progress");
    }

    public Ship modifyShip(String shipId) {
        // TODO
        return null;
    }
}
