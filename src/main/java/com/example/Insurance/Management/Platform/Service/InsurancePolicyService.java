package com.example.Insurance.Management.Platform.Service;

import com.example.Insurance.Management.Platform.Dtos.InsurancePolicyRequestDto;
import com.example.Insurance.Management.Platform.Models.Client;
import com.example.Insurance.Management.Platform.Models.Insurance_policy;
import com.example.Insurance.Management.Platform.Repositories.ClientRepository;
import com.example.Insurance.Management.Platform.Repositories.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class InsurancePolicyService {

    @Autowired
    InsurancePolicyRepository insurancePolicyRepository;

    @Autowired
    ClientRepository clientRepository;

    public String createInsurancePolicy(InsurancePolicyRequestDto insurancePolicyRequestDto, int client_id) {

        Client client;
        try{
            client = clientRepository.findById(client_id).get();
        }
        catch (Exception e){
            return "client not present";
        }

        Insurance_policy insurance_policy = Insurance_policy.builder().policy_no(insurancePolicyRequestDto.getPolicy_no()).
                   insurance_type(insurancePolicyRequestDto.getInsurance_type()).
                    coverage_amount(insurancePolicyRequestDto.getCoverage_amount()).
                     premium(insurancePolicyRequestDto.getPremium()).
                     start_date(insurancePolicyRequestDto.getStart_date()).
                     end_date(insurancePolicyRequestDto.getEnd_date()). build();

        insurance_policy.setClient(client);

        List<Insurance_policy> policies = client.getInsurance_policies();
        if(policies==null){
            policies = new ArrayList<>();
        }

        policies.add(insurance_policy);
        client.setInsurance_policies(policies);

        clientRepository.save(client);

        return "Insurance Policy Created Succesfully!";
    }


    public List<Insurance_policy> getAllInsurancePoliciy() {

        List<Insurance_policy> policies = null;

        try {
            policies = insurancePolicyRepository.findAll();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return policies;

    }

    public Insurance_policy getInsuranceById(int id) {

        Insurance_policy insurance_policy = null;

        try {
            insurance_policy = insurancePolicyRepository.findById(id).get();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

         return insurance_policy;
    }

    public  String updateInsurancePolicy(InsurancePolicyRequestDto insurancePolicyRequestDto, int id){

        Insurance_policy insurance_policy;

        try {
            insurance_policy = insurancePolicyRepository.findById(id).get();
        }
        catch (Exception e){
            return "insurance policy not found";
        }



        insurance_policy.setPolicy_no(insurancePolicyRequestDto.getPolicy_no());
        insurance_policy.setInsurance_type(insurancePolicyRequestDto.getInsurance_type());
        insurance_policy.setCoverage_amount(insurancePolicyRequestDto.getCoverage_amount());
        insurance_policy.setPremium(insurancePolicyRequestDto.getPremium());
        insurance_policy.setStart_date(insurancePolicyRequestDto.getStart_date());
        insurance_policy.setEnd_date(insurancePolicyRequestDto.getEnd_date());

        insurancePolicyRepository.save(insurance_policy);

        return "Insurance policy succesfully updated";

    }

    public String deleteInsurancePolicy(int id) {
        Insurance_policy insurance_policy;
        try {
            insurance_policy = insurancePolicyRepository.findById(id).get();
        }
        catch (Exception e){
            return "Insurance Policy Not Found";
        }

        insurancePolicyRepository.delete(insurance_policy);
        return "Insurance Policy Succesfully deleted";
    }
}
