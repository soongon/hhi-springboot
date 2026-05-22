package com.hhi.springhhi.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "blocks")
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String code;
    private String blockType;
    private double weight;

    @Enumerated(EnumType.STRING)
    private BuildStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ship_id")
    private Ship parentShip;

    public Block() {}

    public Block(long id, String code, String blockType, double weight, BuildStatus status, Ship parentShip) {
        this.id = id;
        this.code = code;
        this.blockType = blockType;
        this.weight = weight;
        this.status = status;
        this.parentShip = parentShip;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBlockType() {
        return blockType;
    }

    public void setBlockType(String blockType) {
        this.blockType = blockType;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public BuildStatus getStatus() {
        return status;
    }

    public void setStatus(BuildStatus status) {
        this.status = status;
    }

    public Ship getParentShip() {
        return parentShip;
    }

    public void setParentShip(Ship parentShip) {
        this.parentShip = parentShip;
    }

    @Override
    public String toString() {
        return "Block{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", blockType='" + blockType + '\'' +
                ", weight=" + weight +
                ", status=" + status +
                ", parentShip=" + parentShip +
                '}';
    }
}