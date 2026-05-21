package com.hhi.springhhi.dto;

// data class, model class, domain class, vo
public class ShipCreateRequest {
    private String id;
    private int shipNumber;
    private String name;
    private String type;
    private double length;
    private double weight;
    private String status;

    public ShipCreateRequest(String id, int shipNumber, String name, String type, double length, double weight, String status) {
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

    public int getShipNumber() {
        return shipNumber;
    }

    public void setShipNumber(int shipNumber) {
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
