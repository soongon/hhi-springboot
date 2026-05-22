package com.hhi.springhhi.service;

import com.hhi.springhhi.domain.Block;
import com.hhi.springhhi.domain.BlockStatus;
import com.hhi.springhhi.domain.Ship;
import com.hhi.springhhi.dto.BlockCreateRequest;
import com.hhi.springhhi.dto.BlockResponse;
import com.hhi.springhhi.exception.HhiShipException;
import com.hhi.springhhi.repository.BlockRepository;
import com.hhi.springhhi.repository.ShipRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BlockService {

    private final ShipRepository shipRepository;
    private final BlockRepository blockRepository;

    public BlockService(ShipRepository shipRepository, BlockRepository blockRepository) {
        this.shipRepository = shipRepository;
        this.blockRepository = blockRepository;
    }

    @Transactional(readOnly = true)
    public List<BlockResponse> getBlocksByShipId(Long shipId) {
        List<Block> blocks =
                blockRepository.findByParentShipIdOrderByBlockCode(shipId);
        // 모선에 포함된 모든 블럭을 가져온다.
        return blocks.stream()
                .map(BlockResponse::from)
                .toList();
    }

    public BlockResponse registBlockWithParentShip(Long shipId, BlockCreateRequest request) {
        // 1. 배가 존재하는지 확인.
        Ship parentShip = shipRepository.findById(shipId)
                .orElseThrow(() -> new HhiShipException("배가 없어요"));
        // 2. 키(blockCode)가 같은 호선 내에서 중복되는지 체크.
        if (blockRepository.existsByParentShipIdAndBlockCode(shipId, request.getBlockCode())) {
            throw new HhiShipException("이미 존재하는 블럭코드입니다: " + request.getBlockCode());
        }
        // 3. 블럭을 추가.. (생성 시 상태는 항상 PLANNED)
        Block newBlock = new Block(
                request.getBlockCode(),
                request.getBlockType(),
                request.getWeight(),
                BlockStatus.PLANNED,
                parentShip
        );
        // 양방향 연관관계 편의 메서드로 양쪽 참조를 맞춘다.
        parentShip.addBlock(newBlock);

        return BlockResponse.from(blockRepository.save(newBlock));
    }
}
