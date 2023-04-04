package com.example.assignment.mapper;

import com.example.assignment.dto.InsaurancePolicyDTO;
import com.example.assignment.entities.InsaurancePolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InsaurancePolicyMapper {

    @Autowired
    ClaimMapper claimMapper;


    public InsaurancePolicyDTO toDTO(InsaurancePolicy insaurancePolicy) {
        if (insaurancePolicy == null) return new InsaurancePolicyDTO();
        InsaurancePolicyDTO dto = new InsaurancePolicyDTO();

        dto.setId(insaurancePolicy.getId());
        dto.setDateCreated(insaurancePolicy.getDateCreated());

        dto.setPolicynumber(insaurancePolicy.getPolicynumber());
        dto.setCoverageAmount(insaurancePolicy.getCoverageAmount());
        dto.setPremium(insaurancePolicy.getPremium());

        dto.setStartDate(insaurancePolicy.getStartDate());
        dto.setEndDate(insaurancePolicy.getEndDate());

        dto.setClaim(claimMapper.toDTO(insaurancePolicy.getClaim()));

        return dto;
    }

    public List<InsaurancePolicyDTO> toDTO(List<InsaurancePolicy> insaurancePolicyList) {
        List<InsaurancePolicyDTO> dtoList = new ArrayList<>();
        for (InsaurancePolicy insaurancePolicy : insaurancePolicyList) {
            dtoList.add(toDTO(insaurancePolicy));
        }
        return dtoList;
    }

    public InsaurancePolicy fromDTO(InsaurancePolicyDTO insaurancePolicyDTO, InsaurancePolicy insaurancePolicy) {
        insaurancePolicy.setPolicynumber(insaurancePolicyDTO.getPolicynumber());
        insaurancePolicy.setCoverageAmount(insaurancePolicyDTO.getCoverageAmount());
        insaurancePolicy.setPremium(insaurancePolicyDTO.getPremium());

        insaurancePolicy.setStartDate(insaurancePolicyDTO.getStartDate());
        insaurancePolicy.setEndDate(insaurancePolicyDTO.getEndDate());


        return insaurancePolicy;
    }
}