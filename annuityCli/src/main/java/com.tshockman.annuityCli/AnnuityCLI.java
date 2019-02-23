package com.tshockman.annuityCli;

import com.tshockman.annuityLib.lib.AnnuityCalculator;
import com.tshockman.annuityLib.models.AnnuityCalculationRequest;
import com.tshockman.annuityLib.models.AnnuityPayment;
import org.json.JSONArray;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collector;

public class AnnuityCLI {

    public static void main(String[] args) {

        double loanAmount = Double.valueOf(args[0]);
        double nominalRate = Double.valueOf(args[1]);
        int duration = Integer.valueOf(args[2]);
        LocalDateTime startDate = LocalDateTime.ofInstant(Instant.parse(args[3]), ZoneOffset.UTC);

        AnnuityCalculationRequest req = new AnnuityCalculationRequest(loanAmount, nominalRate, duration, startDate);
        AnnuityCalculator calc = new AnnuityCalculator();
        List<AnnuityPayment> payments = calc.calculateAnnuity(req);

        JSONArray paymentsJson = payments.stream()
                .map(AnnuityPayment::json)
                .collect(Collector.of(
                        JSONArray::new,
                        JSONArray::put,
                        JSONArray::put));
        String jsonString = paymentsJson.toString(2);
        System.out.println(jsonString);
    }
}
