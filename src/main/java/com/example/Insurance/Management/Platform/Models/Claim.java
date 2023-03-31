package com.example.Insurance.Management.Platform.Models;


import com.example.Insurance.Management.Platform.Enums.Claim_Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "claim")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private int claim_number;

    @Enumerated(value = EnumType.STRING)
    private Claim_Status claim_status;


    private String description;

    @CreationTimestamp
    private Date claim_date;

    @ManyToOne
    @JoinColumn
    private Insurance_policy insurance_policy;

    public Claim(int claim_number, Claim_Status claim_status, String description) {
        this.claim_number = claim_number;
        this.claim_status = claim_status;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClaim_number() {
        return claim_number;
    }

    public void setClaim_number(int claim_number) {
        this.claim_number = claim_number;
    }

    public Claim_Status getClaim_status() {
        return claim_status;
    }

    public void setClaim_status(Claim_Status claim_status) {
        this.claim_status = claim_status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getClaim_date() {
        return claim_date;
    }

    public void setClaim_date(Date claim_date) {
        this.claim_date = claim_date;
    }

    public Insurance_policy getInsurance_policy() {
        return insurance_policy;
    }

    public void setInsurance_policy(Insurance_policy insurance_policy) {
        this.insurance_policy = insurance_policy;
    }
}
