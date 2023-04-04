package com.example.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assignment.entities.InsaurancePolicy;

public interface InsaurancePolicyDao extends JpaRepository<InsaurancePolicy, String> {

}
