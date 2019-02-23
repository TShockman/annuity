package com.tshockman.annuityServer.services;

import com.tshockman.annuityLib.lib.AnnuityCalculator;
import com.tshockman.annuityLib.models.AnnuityCalculationRequest;
import com.tshockman.annuityLib.models.AnnuityPayment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnnuityService {

    private AnnuityCalculator annuityCalculator = new AnnuityCalculator();

    @PostMapping("generate-plan")
    public ResponseEntity<List<AnnuityPayment>> generatePlan(@RequestBody AnnuityCalculationRequest acr) {
        List<AnnuityPayment> annuityPayments = annuityCalculator.calculateAnnuity(acr);
        return ResponseEntity.ok(annuityPayments);
    }

}
