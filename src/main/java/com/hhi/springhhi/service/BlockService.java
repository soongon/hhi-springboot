package com.hhi.springhhi.service;

import com.hhi.springhhi.domain.Block;
import com.hhi.springhhi.domain.BlockStatus;
import com.hhi.springhhi.domain.Ship;
import com.hhi.springhhi.dto.BlockResponse;
import com.hhi.springhhi.exception.HhiShipException;
import com.hhi.springhhi.repository.BlockRepository;
import com.hhi.springhhi.repository.ShipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockService {

    private final ShipRepository shipRepository;
    private final BlockRepository blockRepository;

    public BlockService(ShipRepository shipRepository, BlockRepository blockRepository) {
        this.shipRepository = shipRepository;
        this.blockRepository = blockRepository;
    }

    public List<BlockResponse> getBlocksByShipId(String shipId) {
        List<Block> blocks =
                blockRepository.findByParentShipIdOrderByBlockCode(Long.parseLong(shipId));
        // 모선에 포함된 모든 블럭을 가져온다.
        return blocks.stream()
                .map(BlockResponse::from)
                .toList();
    }

    public Block registBlockWithParentShip(Long shipId, Block block) {
        // 1. 배가 존재하는지 확인.
        Ship parentShip = shipRepository.findById(shipId)
                .orElseThrow(() -> new HhiShipException("배가 없어요"));
        // 2.. 각종 비즈니스로직 포함(예, 인도된 배에는 블럭 포함 불가..)
        // 3. 키가 중복되는지 체크..
        // 4. 블럭을 추가..
        Block newBlock = new Block(
                block.getBlockCode(),
                block.getBlockType(),
                block.getWeight(),
                BlockStatus.PLANNED,
                parentShip
        );

        return blockRepository.save(newBlock);
    }
}
