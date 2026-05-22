package com.hhi.springhhi.dto;

import com.hhi.springhhi.domain.Ship;
import com.hhi.springhhi.domain.ShipStatus;
import com.hhi.springhhi.domain.ShipType;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "배 정보 DTO")
public record ShipResponse (
    long id,
    @Schema(description = "배번호", example = "HHI-SHIP-001")
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
