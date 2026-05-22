package com.hhi.springhhi.controller;

import com.hhi.springhhi.dto.BlockCreateRequest;
import com.hhi.springhhi.dto.BlockResponse;
import com.hhi.springhhi.service.BlockService;
import jakarta.validation.Valid;
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
    public BlockResponse registBlock(
            @PathVariable Long shipId,
            @Valid @RequestBody BlockCreateRequest request) {
        return blockService.registBlockWithParentShip(shipId, request);
    }

    // 배의 블럭 전체보기
    @GetMapping("/ships/{shipId}/blocks")
    public List<BlockResponse> getBlocksByShipId(@PathVariable Long shipId) {
        return blockService.getBlocksByShipId(shipId);
    }
}
