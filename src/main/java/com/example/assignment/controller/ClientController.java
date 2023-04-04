package com.example.assignment.controller;

import com.example.assignment.dto.ClientDTO;
import com.example.assignment.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/client")
@RestController
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping("/{id}")
    public ClientDTO get(@PathVariable String id) {
        return clientService.getById(id);
    }

    @PostMapping("")
    public ClientDTO save(@RequestBody ClientDTO dto) {
        return clientService.save(dto);
    }

    @GetMapping("/list")
    public List<ClientDTO> getList(Pageable pageable) {
        return clientService.findAll(pageable).getContent();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        clientService.delete(id);
    }
}
