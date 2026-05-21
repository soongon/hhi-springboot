package com.hhi.springhhi.dto;

import com.hhi.springhhi.domain.ShipStatus;
import com.hhi.springhhi.domain.ShipType;

// data class, model class, domain class, vo
public class ShipCreateRequest {
    private String id;
    private String shipNumber;
    private String name;
    private ShipType type;
    private double length;
    private double weight;
    private ShipStatus status;

    public ShipCreateRequest(String id, String shipNumber, String name, ShipType type, double length, double weight, ShipStatus status) {
        this.id = id;
        this.shipNumber = shipNumber;
        this.name = name;
        this.type = type;
        this.length = length;
        this.weight = weight;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShipNumber() {
        return shipNumber;
    }

    public void setShipNumber(String shipNumber) {
        this.shipNumber = shipNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShipType getType() {
        return type;
    }

    public void setType(ShipType type) {
        this.type = type;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public ShipStatus getStatus() {
        return status;
    }

    public void setStatus(ShipStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "id='" + id + '\'' +
                ", shipNumber=" + shipNumber +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", height=" + length +
                ", weight=" + weight +
                ", status='" + status + '\'' +
                '}';
    }
}
