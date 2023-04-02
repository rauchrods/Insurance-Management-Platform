package com.example.Insurance.Management.Platform.Controllers;

import com.example.Insurance.Management.Platform.Dtos.ClientRequestDto;
import com.example.Insurance.Management.Platform.Dtos.InsurancePolicyRequestDto;
import com.example.Insurance.Management.Platform.Models.Client;
import com.example.Insurance.Management.Platform.Models.Insurance_policy;
import com.example.Insurance.Management.Platform.Service.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurance_policy")
public class InsurancePolicyContoller {

    @Autowired
    InsurancePolicyService insurancePolicyService;


    @PostMapping("/create")
    public ResponseEntity<String> createInsurancePolicy(@RequestBody() InsurancePolicyRequestDto insurancePolicyRequestDto, @RequestParam("client_id") int client_id) {
        String str = insurancePolicyService.createInsurancePolicy(insurancePolicyRequestDto, client_id);
        if (str == "client not present") {
            return new ResponseEntity<>(str, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(str, HttpStatus.ACCEPTED);
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Insurance_policy>> getAllInsurancePoliciy() {

        List<Insurance_policy> policies = insurancePolicyService.getAllInsurancePoliciy();

        if (policies == null) {
            return new ResponseEntity<>(policies, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(policies, HttpStatus.ACCEPTED);
        }

    }

    @GetMapping("getbyid")
    public ResponseEntity<Insurance_policy> getInsuranceById(@RequestParam("id") int id) {

          Insurance_policy insurance_policy =  insurancePolicyService.getInsuranceById(id);

        if (insurance_policy == null) {
            return new ResponseEntity<>(insurance_policy, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(insurance_policy, HttpStatus.ACCEPTED);

        }
    }

    @PutMapping("update")
    public  ResponseEntity<String> updateInsurancePolicy(@RequestBody() InsurancePolicyRequestDto insurancePolicyRequestDto, @RequestParam("id") int id){
          String str =  insurancePolicyService.updateInsurancePolicy(insurancePolicyRequestDto,id);
          if(str=="insurance policy not found"){
              return  new ResponseEntity<>(str,HttpStatus.NOT_FOUND);
          }
          else{
              return  new ResponseEntity<>(str,HttpStatus.ACCEPTED);
          }
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteInsurancePolicy(@RequestParam("id") int id) {

        String str = insurancePolicyService.deleteInsurancePolicy(id);

        if (str == "Insurance Policy Not Found") {
            return new ResponseEntity<>(str, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(str, HttpStatus.ACCEPTED);
        }

    }
}
