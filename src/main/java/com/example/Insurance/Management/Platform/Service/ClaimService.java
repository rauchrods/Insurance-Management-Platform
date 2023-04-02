package com.example.Insurance.Management.Platform.Service;

import com.example.Insurance.Management.Platform.Dtos.ClaimRequestDto;
import com.example.Insurance.Management.Platform.Models.Claim;
import com.example.Insurance.Management.Platform.Models.Insurance_policy;
import com.example.Insurance.Management.Platform.Repositories.ClaimRepository;
import com.example.Insurance.Management.Platform.Repositories.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClaimService {

    @Autowired
    ClaimRepository claimRepository;

    @Autowired
    InsurancePolicyRepository insurancePolicyRepository;

    public String createClaim(ClaimRequestDto claimRequestDto, int id) {
        Claim claim = Claim.builder().claim_number(claimRequestDto.getClaim_number()).
                claim_status(claimRequestDto.getClaim_status()).
                description(claimRequestDto.getDescription()).build();

        Insurance_policy insurance_policy = null;
        try {
            insurance_policy = insurancePolicyRepository.findById(id).get();
        } catch (Exception e) {
            return "Insurance Policy not present";
        }

        claim.setInsurance_policy(insurance_policy);

        List<Claim> claims = insurance_policy.getClaims();
        if (claims == null) {
            claims = new ArrayList<>();
        }
        claims.add(claim);
        insurance_policy.setClaims(claims);

        insurancePolicyRepository.save(insurance_policy);

        return "claim succesfully added";

    }

    public List<Claim> getAllClaims() {
        List<Claim> claims = null;
        try {
            claims = claimRepository.findAll();
        } catch (Exception e) {
            System.out.println("Unable to get claims");
        }

        return claims;
    }

    public Claim getClaimById(int id) {

        Claim claim = null;
        try {
            claim = claimRepository.findById(id).get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return claim;
    }

    public String updateClaim(ClaimRequestDto claimRequestDto,int id) {

        Claim claim;
        try {
            claim = claimRepository.findById(id).get();
        }
        catch (Exception e){
            return "Claim no to be updated was not found";
        }

        claim.setClaim_number(claimRequestDto.getClaim_number());
        claim.setClaim_status(claimRequestDto.getClaim_status());
        claim.setDescription(claimRequestDto.getDescription());

        claimRepository.save(claim);

        return "Claim has been suceesfully updated";
    }


    public String deleteClaim(int id) {

        Claim claim = null;

        try{
            claim = claimRepository.findById(id).get();
        }
        catch (Exception e){
            return "claim not found";
        }

        claimRepository.delete(claim);

        return "claim deleted successfully";
    }
}
