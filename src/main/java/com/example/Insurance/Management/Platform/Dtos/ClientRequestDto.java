package com.example.Insurance.Management.Platform.Dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDto {

    private String name;

    private Date date_of_birth;

    private String address;

    private long contact_information;
}
