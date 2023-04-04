package com.example.assignment.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ToString
@Getter
@Setter
public class ClientDTO {

    private String id;

    private Date dateCreated;


    private String name;
    private Date dob;
    private String address;
    private Integer phone;

    List<InsaurancePolicyDTO> insaurancePolicyList = new ArrayList<>();

}