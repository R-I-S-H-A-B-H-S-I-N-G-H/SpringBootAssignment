package com.example.assignment.service;

import com.example.assignment.dao.ClientDao;
import com.example.assignment.dto.ClientDTO;
import com.example.assignment.entities.Client;
import com.example.assignment.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientDao clientDao;

    @Autowired
    ClientMapper clientMapper;

    @Autowired
    InsaurancePolicyService insaurancePolicyService;

    public ClientDTO getById(String id) {
        Optional<Client> optional = clientDao.findById(id);
        return clientMapper.toDTO(optional.orElse(null));
    }

    public ClientDTO save(ClientDTO dto) {
        if (dto.getId() == null) dto.setId("");
        Optional<Client> optional = clientDao.findById(dto.getId());
        Client client = clientMapper.fromDTO(dto, optional.orElse(new Client()));
        clientDao.save(client);
        client.setInsaurancePolicyList(insaurancePolicyService.saveEntity(dto.getInsaurancePolicyList()));

        clientDao.save(client);
        return clientMapper.toDTO(client);
    }

    public Client saveEntity(ClientDTO dto) {
        if (dto == null) return null;
        if (dto.getId() == null) dto.setId("");
        Optional<Client> optional = clientDao.findById(dto.getId());
        Client client = clientMapper.fromDTO(dto, optional.orElse(new Client()));
        clientDao.save(client);
        client.setInsaurancePolicyList(insaurancePolicyService.saveEntity(dto.getInsaurancePolicyList()));

        clientDao.save(client);
        return client;
    }

    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> page = clientDao.findAll(pageable);
        return page.map(ele -> clientMapper.toDTO(ele));
    }

    public void delete(String id) {
        if (id == null) id = "";
        clientDao.deleteById(id);
    }

}
