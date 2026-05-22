package com.hhi.springhhi.dto;

import com.hhi.springhhi.domain.ShipStatus;
import com.hhi.springhhi.domain.ShipType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ShipUpdateRequest {
    @NotBlank(message = "선명은 필수입니다")
    private String name;

    @NotNull(message = "선종은 필수입니다")
    private ShipType type;

    @Positive(message = "길이는 0보다 커야 합니다")
    private double length;

    @Positive(message = "중량은 0보다 커야 합니다")
    private double weight;

    @NotNull(message = "상태는 필수입니다")
    private ShipStatus status;

    public ShipUpdateRequest() {}

    public ShipUpdateRequest(String name, ShipType type, double length, double weight, ShipStatus status) {
        this.name = name;
        this.type = type;
        this.length = length;
        this.weight = weight;
        this.status = status;
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
        return "ShipUpdateRequest{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", length=" + length +
                ", weight=" + weight +
                ", status=" + status +
                '}';
    }
}
