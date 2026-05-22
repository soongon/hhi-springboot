package com.hhi.springhhi.dto;

import com.hhi.springhhi.domain.Block;
import com.hhi.springhhi.domain.BlockStatus;

public record BlockResponse(
        Long id,
        String blockCode,
        String blockType,
        double weight,
        BlockStatus status,
        Long shipId,           // parentShip을 통째로 X — 식별자만
        String shipNumber      // 편의용: 클라이언트가 호선 조회 한 번 더 안 하게
) {
    public static BlockResponse from(Block block) {
        return new BlockResponse(
                block.getId(),
                block.getBlockCode(),
                block.getBlockType(),
                block.getWeight(),
                block.getStatus(),
                block.getParentShip().getId(),
                block.getParentShip().getShipNumber()
        );
    }
}