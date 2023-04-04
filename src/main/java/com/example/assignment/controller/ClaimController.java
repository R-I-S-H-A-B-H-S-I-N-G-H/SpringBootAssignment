package com.example.assignment.controller;

import com.example.assignment.dto.ClaimDTO;
import com.example.assignment.entities.Claim;
import com.example.assignment.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/claim")
@RestController
public class ClaimController {

    @Autowired
    ClaimService claimService;

    @GetMapping("/{id}")
    public ClaimDTO get(@PathVariable String id) {
        return claimService.getById(id);
    }

    @PostMapping("")
    public ClaimDTO save(@RequestBody ClaimDTO dto) {
        return claimService.save(dto);
    }

    @GetMapping("/list")
    public List<ClaimDTO> getList(Pageable pageable) {

        System.out.println();
        System.out.println();
        Claim claim = new Claim();
        System.out.println(claim);
        System.out.println();
        System.out.println();
        return claimService.findAll(pageable).getContent();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        claimService.delete(id);
    }


}
