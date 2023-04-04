package com.example.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assignment.entities.Client;

public interface ClientDao extends JpaRepository<Client, String> {

}
