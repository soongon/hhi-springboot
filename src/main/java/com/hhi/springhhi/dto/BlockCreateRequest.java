package com.hhi.springhhi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

// 블럭 생성 요청 DTO — 엔티티(Block)를 직접 받지 않는다.
// id/status/parentShip 은 서버가 결정하므로 받지 않는다.
public class BlockCreateRequest {
    @NotBlank(message = "블럭코드는 필수입니다")
    private String blockCode;

    @NotBlank(message = "블럭타입은 필수입니다")
    private String blockType;

    @PositiveOrZero(message = "중량은 0 이상이어야 합니다")
    private double weight;

    public BlockCreateRequest() {}

    public BlockCreateRequest(String blockCode, String blockType, double weight) {
        this.blockCode = blockCode;
        this.blockType = blockType;
        this.weight = weight;
    }

    public String getBlockCode() {
        return blockCode;
    }

    public void setBlockCode(String blockCode) {
        this.blockCode = blockCode;
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
}
