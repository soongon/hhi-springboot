package com.hhi.springhhi.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    // ===== ★ 양방향 연관관계 추가 =====
    @OneToMany(mappedBy = "parentShip", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Block> blocks = new ArrayList<>();


    public Ship() {}

    public Ship(String shipNumber, String name, ShipType type, double length, double weight, ShipStatus status) {
        this.shipNumber = shipNumber;
        this.name = name;
        this.type = type;
        this.length = length;
        this.weight = weight;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Block> getBlocks() {
        return blocks;
    }

    // 양방향 연관관계 편의 메서드: 양쪽 참조를 함께 맞춰준다.
    public void addBlock(Block block) {
        blocks.add(block);
        block.setParentShip(this);
    }

    // JPA 엔티티는 식별자(id)로만 동일성을 판단한다.
    // (모든 필드 기반 equals/hashCode는 영속 상태에 따라 값이 바뀌어 컬렉션에서 문제를 일으킴)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return id != null && id.equals(ship.id);
    }

    @Override
    public int hashCode() {
        // id가 부여되기 전후로 hashCode가 바뀌지 않도록 클래스 단위 상수를 사용한다.
        return getClass().hashCode();
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
