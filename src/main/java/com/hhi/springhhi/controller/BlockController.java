package com.hhi.springhhi.controller;

import com.hhi.springhhi.service.BlockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlockController {

    private final BlockService blockService;

    public BlockController(BlockService blockService) {
        this.blockService = blockService;
    }

    // 배의 블럭 전체보기
    @GetMapping("/ships/{shipId}/blocks")
    public List<BlockResponse> getBlocksByShipId(@PathVariable String shipId) {
        return blockService.getBlocksByShipId(shipId);
    }
}
