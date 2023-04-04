package com.example.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assignment.entities.Claim;

public interface ClaimDao extends JpaRepository<Claim, String> {

}
