package com.example.Insurance.Management.Platform.Dtos;


import com.example.Insurance.Management.Platform.Enums.Insurance_type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsurancePolicyRequestDto {
    @Column(unique = true , nullable = false)
    private int policy_no;

    @Enumerated(value = EnumType.STRING)
    private Insurance_type insurance_type;

    private int coverage_amount;

    private int premium;

    private Date start_date;

    private Date end_date;
}
