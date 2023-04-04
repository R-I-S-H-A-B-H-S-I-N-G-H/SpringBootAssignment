package com.example.assignment.service;

import com.example.assignment.dao.ClaimDao;
import com.example.assignment.dto.ClaimDTO;
import com.example.assignment.entities.Claim;
import com.example.assignment.mapper.ClaimMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClaimService {

    @Autowired
    ClaimDao claimDao;

    @Autowired
    ClaimMapper claimMapper;

    public ClaimDTO getById(String id) {
        if (id == null) id = "";
        Optional<Claim> optional = claimDao.findById(id);
        return claimMapper.toDTO(optional.orElse(new Claim()));
    }

    public ClaimDTO save(ClaimDTO dto) {
        if (dto.getId() == null) dto.setId("");
        Optional<Claim> optional = claimDao.findById(dto.getId());
        Claim claim = claimMapper.fromDTO(dto, optional.orElse(new Claim()));
        return claimMapper.toDTO(claimDao.save(claim));
    }

    public Claim saveEntity(ClaimDTO dto) {
        if (dto == null) return null;
        if (dto.getId() == null) dto.setId("");
        Optional<Claim> optional = claimDao.findById(dto.getId());
        Claim claim = claimMapper.fromDTO(dto, optional.orElse(new Claim()));
        return (claimDao.save(claim));
    }

    public Page<ClaimDTO> findAll(Pageable pageable) {
        Page<Claim> page = claimDao.findAll(pageable);
        return page.map(ele -> claimMapper.toDTO(ele));
    }

    public void delete(String id) {
        if (id == null) id = "";
        claimDao.deleteById(id);
    }
}
