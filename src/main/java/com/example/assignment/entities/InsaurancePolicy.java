package com.example.assignment.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

/**
 * InsaurancePolicy
 */
@ToString
@Entity
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
public class InsaurancePolicy {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated = new Date();

    private Integer policynumber;
    private Integer coverageAmount;
    private Integer premium;
    private Date startDate;
    private Date endDate;


    private String type;

//    @ManyToOne
//    @JoinColumn(name = "client_id", referencedColumnName = "id")
//    private Client client;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "claim_id", referencedColumnName = "id")
    private Claim claim;
}