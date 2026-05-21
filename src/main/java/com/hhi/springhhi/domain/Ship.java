package com.hhi.springhhi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "ships")
public class Ship {
    @Id
    private long id;
    private String shipNumber;
    private String name;
    private String type;
    private double length;
    private double weight;
    private String status;

    public Ship() {}

    public Ship(long id, String shipNumber, String name, String type, double length, double weight, String status) {
        this.id = id;
        this.shipNumber = shipNumber;
        this.name = name;
        this.type = type;
        this.length = length;
        this.weight = weight;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return id == ship.id && Double.compare(length, ship.length) == 0 && Double.compare(weight, ship.weight) == 0 && Objects.equals(shipNumber, ship.shipNumber) && Objects.equals(name, ship.name) && Objects.equals(type, ship.type) && Objects.equals(status, ship.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shipNumber, name, type, length, weight, status);
    }

    @Override
    public String toString() {
        return "Ship{" +
                "id=" + id +
                ", shipNumber='" + shipNumber + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", length=" + length +
                ", weight=" + weight +
                ", status='" + status + '\'' +
                '}';
    }
}
