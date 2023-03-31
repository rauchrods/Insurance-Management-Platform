package com.example.Insurance.Management.Platform.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="client")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private Date date_of_birth;

    private String address;

    private long contact_information;

    @CreationTimestamp
    private Date created_on;


    @UpdateTimestamp
    private Date updated_on;

    @OneToMany(mappedBy = "client" , cascade = CascadeType.ALL)
    List<Insurance_policy> insurance_policies;


    public Client(String name, Date date_of_birth, String address, long contact_information) {
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.address = address;
        this.contact_information = contact_information;
        insurance_policies = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getContact_information() {
        return contact_information;
    }

    public void setContact_information(long contact_information) {
        this.contact_information = contact_information;
    }
}
