package com.example.Insurance.Management.Platform.Dtos;

import com.example.Insurance.Management.Platform.Enums.Claim_Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClaimRequestDto {
    @Column(unique = true, nullable = false)
    private int claim_number;

    @Enumerated(value = EnumType.STRING)
    private Claim_Status claim_status;


    private String description;
}
