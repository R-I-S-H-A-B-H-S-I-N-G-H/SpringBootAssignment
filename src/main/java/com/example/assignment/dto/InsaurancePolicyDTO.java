package com.example.assignment.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class InsaurancePolicyDTO {

    private String id;

    private Date dateCreated;


    private Integer policynumber;
    private Integer coverageAmount;
    private Integer premium;
    private Date startDate;
    private Date endDate;


    private String type;
//    private ClientDTO client;

    private ClaimDTO claim;
}