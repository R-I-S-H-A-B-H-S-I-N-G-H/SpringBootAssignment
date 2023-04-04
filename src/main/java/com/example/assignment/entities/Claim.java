package com.example.assignment.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@ToString
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Claim {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated = new Date();

    private String claimStatus;
    private Integer claimNumber;
    private String claimDesc;
    private Date claimDate;


//    @OneToOne(mappedBy = "claim")
//    private InsaurancePolicy insaurancePolicy;

}