package com.example.assignment.controller;

import com.example.assignment.dto.InsaurancePolicyDTO;
import com.example.assignment.service.InsaurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/insaurance")
@RestController
public class InsaurancePolicyController {
    @Autowired
    InsaurancePolicyService insaurancePolicyService;

    @GetMapping("/{id}")
    public InsaurancePolicyDTO get(@PathVariable String id) {
        return insaurancePolicyService.getById(id);
    }

    @PostMapping("")
    public InsaurancePolicyDTO save(@RequestBody InsaurancePolicyDTO dto) {
        return insaurancePolicyService.save(dto);
    }

    @GetMapping("/list")
    public List<InsaurancePolicyDTO> getList(Pageable pageable) {
        return insaurancePolicyService.findAll(pageable).getContent();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        insaurancePolicyService.delete(id);
    }
}
