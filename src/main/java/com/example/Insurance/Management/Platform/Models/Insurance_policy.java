package com.example.Insurance.Management.Platform.Models;


import com.example.Insurance.Management.Platform.Enums.Insurance_type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "insurance_policy")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Insurance_policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true , nullable = false)
    private int policy_no;

    @Enumerated(value = EnumType.STRING)
    private Insurance_type insurance_type;

    private int coverage_amount;

    private int premium;

    private Date start_date;

    private Date end_date;


    @ManyToOne
    @JoinColumn
    private Client client;

    @OneToMany(mappedBy = "insurance_policy", cascade = CascadeType.ALL)
    private List<Claim> claims;



    public Insurance_policy(int policy_no, Insurance_type insurance_type, int coverage_amount, int premium, Date start_date, Date end_date) {
        this.policy_no = policy_no;
        this.insurance_type = insurance_type;
        this.coverage_amount = coverage_amount;
        this.premium = premium;
        this.start_date = start_date;
        this.end_date = end_date;
        claims = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPolicy_no() {
        return policy_no;
    }

    public void setPolicy_no(int policy_no) {
        this.policy_no = policy_no;
    }

    public Insurance_type getInsurance_type() {
        return insurance_type;
    }

    public void setInsurance_type(Insurance_type insurance_type) {
        this.insurance_type = insurance_type;
    }

    public int getCoverage_amount() {
        return coverage_amount;
    }

    public void setCoverage_amount(int coverage_amount) {
        this.coverage_amount = coverage_amount;
    }

    public int getPremium() {
        return premium;
    }

    public void setPremium(int premium) {
        this.premium = premium;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
