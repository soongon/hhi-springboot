package com.hhi.springhhi.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ships")
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String shipNumber;
    private String name;

    @Enumerated(EnumType.STRING)
    private ShipType type;

    private double length;
    private double weight;

    @Enumerated(EnumType.STRING)
    private ShipStatus status;

    public Ship() {}

    public Ship(String shipNumber, String name, ShipType type, double length, double weight, ShipStatus status) {
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
