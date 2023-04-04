package com.example.assignment.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Client {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated = new Date();


    private String name;
    private Date dob;
    private String address;
    private Integer phone;

//    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
//    List<InsaurancePolicy> insaurancePolicyList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "client_insaurance_policy",
            joinColumns = {@JoinColumn(name = "client_insaurance_policy_id")},
            inverseJoinColumns = {@JoinColumn(name = "insaurance_policy_id")})
    List<InsaurancePolicy> insaurancePolicyList;

}