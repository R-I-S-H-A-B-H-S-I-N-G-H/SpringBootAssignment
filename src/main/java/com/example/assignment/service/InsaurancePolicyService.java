package com.example.assignment.service;

import com.example.assignment.dao.InsaurancePolicyDao;
import com.example.assignment.dto.InsaurancePolicyDTO;
import com.example.assignment.entities.InsaurancePolicy;
import com.example.assignment.mapper.InsaurancePolicyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InsaurancePolicyService {
    @Autowired
    InsaurancePolicyDao insaurancePolicyDao;

    @Autowired
    InsaurancePolicyMapper insaurancePolicyMapper;

    @Autowired
    ClaimService claimService;

    public InsaurancePolicyDTO getById(String id) {
        Optional<InsaurancePolicy> optional = insaurancePolicyDao.findById(id);
        return insaurancePolicyMapper.toDTO(optional.orElse(new InsaurancePolicy()));
    }

    public InsaurancePolicyDTO save(InsaurancePolicyDTO dto) {
        if (dto.getId() == null) dto.setId("");
        Optional<InsaurancePolicy> optional = insaurancePolicyDao.findById(dto.getId());
        InsaurancePolicy insaurancePolicy = insaurancePolicyMapper.fromDTO(dto, optional.orElse(new InsaurancePolicy()));
        insaurancePolicyDao.save(insaurancePolicy);

        insaurancePolicy.setClaim(claimService.saveEntity(dto.getClaim()));
        insaurancePolicyDao.save(insaurancePolicy);

        return insaurancePolicyMapper.toDTO(insaurancePolicy);
    }

    public InsaurancePolicy saveEntity(InsaurancePolicyDTO dto) {
        if (dto == null) return null;
        if (dto.getId() == null) dto.setId("");
        Optional<InsaurancePolicy> optional = insaurancePolicyDao.findById(dto.getId());
        InsaurancePolicy insaurancePolicy = insaurancePolicyMapper.fromDTO(dto, optional.orElse(new InsaurancePolicy()));
        insaurancePolicyDao.save(insaurancePolicy);

        insaurancePolicy.setClaim(claimService.saveEntity(dto.getClaim()));
        insaurancePolicyDao.save(insaurancePolicy);

        return insaurancePolicy;
    }

    public List<InsaurancePolicy> saveEntity(List<InsaurancePolicyDTO> dtoList) {
        List<InsaurancePolicy> insaurancePolicyList = new ArrayList<>();
        for (InsaurancePolicyDTO dto : dtoList) insaurancePolicyList.add(saveEntity(dto));
        return insaurancePolicyList;
    }

    public Page<InsaurancePolicyDTO> findAll(Pageable pageable) {
        Page<InsaurancePolicy> page = insaurancePolicyDao.findAll(pageable);
        return page.map(ele -> insaurancePolicyMapper.toDTO(ele));
    }

    public void delete(String id) {
        if (id == null) id = "";
        insaurancePolicyDao.deleteById(id);
    }

}
