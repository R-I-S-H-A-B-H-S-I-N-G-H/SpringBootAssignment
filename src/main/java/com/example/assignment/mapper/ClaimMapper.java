package com.example.assignment.mapper;

import com.example.assignment.dto.ClaimDTO;
import com.example.assignment.entities.Claim;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClaimMapper {


    public ClaimDTO toDTO(Claim claim) {
        if (claim == null) return new ClaimDTO();
        ClaimDTO dto = new ClaimDTO();

        dto.setId(claim.getId());
        dto.setDateCreated(claim.getDateCreated());

        dto.setClaimDate(claim.getClaimDate());
        dto.setClaimStatus(claim.getClaimStatus());
        dto.setClaimNumber(claim.getClaimNumber());
        dto.setClaimDesc(claim.getClaimDesc());

        return dto;
    }

    public List<ClaimDTO> toDTO(List<Claim> claimList) {
        List<ClaimDTO> dtoList = new ArrayList<>();
        for (Claim claim : claimList) {
            dtoList.add(toDTO(claim));
        }
        return dtoList;
    }

    public Claim fromDTO(ClaimDTO claimDTO, Claim claim) {
        if (claim == null) claim = new Claim();
        claim.setClaimDate(claimDTO.getClaimDate());
        claim.setClaimStatus(claimDTO.getClaimStatus());
        claim.setClaimNumber(claimDTO.getClaimNumber());
        claim.setClaimDesc(claimDTO.getClaimDesc());

        return claim;
    }
}