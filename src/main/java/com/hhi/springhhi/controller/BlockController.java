package com.hhi.springhhi.controller;

import com.hhi.springhhi.domain.Block;
import com.hhi.springhhi.dto.BlockResponse;
import com.hhi.springhhi.service.BlockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlockController {

    private final BlockService blockService;

    public BlockController(BlockService blockService) {
        this.blockService = blockService;
    }

    // 블럭 생성
    @PostMapping("/ships/{shipId}/blocks")
    public Block registBlock(
            @PathVariable Long shipId,
            @RequestBody Block block) {
        return blockService.registBlockWithParentShip(shipId, block);
    }

    // 배의 블럭 전체보기
    @GetMapping("/ships/{shipId}/blocks")
    public List<Block> getBlocksByShipId(@PathVariable String shipId) {
        return blockService.getBlocksByShipId(shipId);
    }
}
