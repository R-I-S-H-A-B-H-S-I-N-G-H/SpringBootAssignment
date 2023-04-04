package com.example.assignment.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ClaimDTO {
    private String id;

    private Date dateCreated;


    private String claimStatus;
    private Integer claimNumber;
    private String claimDesc;
    private Date claimDate;
}