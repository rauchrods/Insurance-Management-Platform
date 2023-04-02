package com.example.Insurance.Management.Platform.Repositories;

import com.example.Insurance.Management.Platform.Models.Insurance_policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsurancePolicyRepository extends JpaRepository<Insurance_policy, Integer> {

}
