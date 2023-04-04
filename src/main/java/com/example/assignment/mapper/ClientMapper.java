package com.example.assignment.mapper;

import com.example.assignment.dto.ClientDTO;
import com.example.assignment.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientMapper {

    @Autowired
    InsaurancePolicyMapper insaurancePolicyMapper;

    public ClientDTO toDTO(Client client) {
        if (client == null) return new ClientDTO();
        ClientDTO dto = new ClientDTO();

        dto.setId(client.getId());
        dto.setDateCreated(client.getDateCreated());

        dto.setName(client.getName());
        dto.setDob(client.getDob());
        dto.setAddress(client.getAddress());
        dto.setPhone(client.getPhone());
        dto.setInsaurancePolicyList(insaurancePolicyMapper.toDTO(client.getInsaurancePolicyList()));

        return dto;
    }

    public List<ClientDTO> toDTO(List<Client> clientList) {
        List<ClientDTO> dtoList = new ArrayList<>();
        for (Client client : clientList) {
            dtoList.add(toDTO(client));
        }
        return dtoList;
    }

    public Client fromDTO(ClientDTO ClientDTO, Client client) {
        client.setName(ClientDTO.getName());
        client.setDob(ClientDTO.getDob());
        client.setAddress(ClientDTO.getAddress());
        client.setPhone(ClientDTO.getPhone());

        return client;
    }
}