package com.example.Insurance.Management.Platform.Controllers;

import com.example.Insurance.Management.Platform.Dtos.ClaimRequestDto;
import com.example.Insurance.Management.Platform.Dtos.ClientRequestDto;
import com.example.Insurance.Management.Platform.Models.Claim;
import com.example.Insurance.Management.Platform.Models.Client;
import com.example.Insurance.Management.Platform.Service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/claim")
public class ClaimController {

    @Autowired
    ClaimService claimService;

    @PostMapping("create")
    public ResponseEntity<String> createClaim(@RequestBody()ClaimRequestDto claimRequestDto, @RequestParam("policy_no") int id) {
        String str =  claimService.createClaim(claimRequestDto,id);
        if(str=="Insurance Policy not present"){
            return  new ResponseEntity<>(str, HttpStatus.NOT_FOUND);
        }
        else{
            return  new ResponseEntity<>(str, HttpStatus.ACCEPTED);
        }
    }

    @GetMapping("getall")
    public ResponseEntity<List<Claim>> getAllClaims() {
        List<Claim> claims =  claimService.getAllClaims();
        if(claims==null){
            return  new ResponseEntity<>(claims, HttpStatus.NOT_FOUND);
        }
        else{
            return  new ResponseEntity<>(claims, HttpStatus.ACCEPTED);
        }
    }


    @GetMapping("getbyid")
    public ResponseEntity<Claim> getClaimById(@RequestParam("id") int id){
             Claim claim =   claimService.getClaimById(id);

        if(claim==null){
            return  new ResponseEntity<>(claim, HttpStatus.NOT_FOUND);
        }
        else{
            return  new ResponseEntity<>(claim, HttpStatus.ACCEPTED);
        }
    }

    @PutMapping("update")
    public ResponseEntity<String> updateClaim(@RequestBody() ClaimRequestDto claimRequestDto, @RequestParam("id") int id) {
          String str =  claimService.updateClaim(claimRequestDto,id);

          if(str=="Claim no to be updated was not found"){
              return  new ResponseEntity<>(str, HttpStatus.NOT_FOUND);
          }
          else{
              return  new ResponseEntity<>(str, HttpStatus.ACCEPTED);
          }
    }


    @DeleteMapping("delete")
    public ResponseEntity<String> deleteClaim(@RequestParam("id") int id) {
           String str =  claimService.deleteClaim(id);
        if(str=="claim not found"){
            return  new ResponseEntity<>(str, HttpStatus.NOT_FOUND);
        }
        else{
            return  new ResponseEntity<>(str, HttpStatus.ACCEPTED);
        }
    }


}
