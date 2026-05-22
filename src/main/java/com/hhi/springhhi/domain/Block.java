package com.hhi.springhhi.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "blocks")
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String blockCode;
    private String blockType;
    private double weight;

    @Enumerated(EnumType.STRING)
    private BlockStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ship_id", nullable = false)
    private Ship parentShip;

    public Block() {}

    public Block(String blockcode, String blockType, double weight, BlockStatus status, Ship parentShip) {
        this.blockCode = blockcode;
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

    public String getBlockCode() {
        return blockCode;
    }

    public void setBlockCode(String code) {
        this.blockCode = code;
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

    public BlockStatus getStatus() {
        return status;
    }

    public void setStatus(BlockStatus status) {
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
                ", blockCode='" + blockCode + '\'' +
                ", blockType='" + blockType + '\'' +
                ", weight=" + weight +
                ", status=" + status +
                ", parentShip=" + parentShip +
                '}';
    }
}