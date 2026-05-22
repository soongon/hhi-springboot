package com.hhi.springhhi.dto;

import com.hhi.springhhi.domain.Ship;
import com.hhi.springhhi.domain.ShipStatus;
import com.hhi.springhhi.domain.ShipType;

public record ShipResponse (
    long id,
    String shipNumber,
    String name,
    ShipType type,
    double length,
    double weight,
    ShipStatus status
) {
    public static ShipResponse from(Ship ship) {
        return new ShipResponse(
                ship.getId(), ship.getShipNumber(), ship.getName(), ship.getType(),
                ship.getLength(), ship.getWeight(), ship.getStatus());
    }
}
