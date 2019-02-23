package com.tshockman.annuityServer.services;

import com.tshockman.annuityLib.lib.AnnuityCalculator;
import com.tshockman.annuityLib.models.AnnuityCalculationRequest;
import com.tshockman.annuityLib.models.AnnuityPayment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class AnnuityService {

    private AnnuityCalculator annuityCalculator = new AnnuityCalculator();

    @PostMapping("generate-plan")
    public ResponseEntity<List<AnnuityPayment>> generatePlan(@RequestBody AnnuityCalculationRequest acr) {

        // ensure request has all information
        if (Objects.isNull(acr)
                || acr.getDuration() < 1
                || acr.getLoanAmount() < 1
                || acr.getNominalRate() < 0
                || acr.getNominalRate() > 100
                || Objects.isNull(acr.getStartDate())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        // declare eventual return value
        List<AnnuityPayment> annuityPayments;

        // try to calculate and catch any errors, returning 500 if so
        try {
             annuityPayments = annuityCalculator.calculateAnnuity(acr);
        } catch (Error e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        // return list of payments to client
        return ResponseEntity.ok(annuityPayments);
    }

}
