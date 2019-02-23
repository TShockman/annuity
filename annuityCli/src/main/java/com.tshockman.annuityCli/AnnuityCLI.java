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

// main class for running annuity calculation as a jar from command line
public class AnnuityCLI {

    // command line arguments are <loan amount> <nominal rate as percentage> <duration in months> <start date in UTC datetime format>
    public static void main(String[] args) {

        // parse command line arguments
        double loanAmount = Double.valueOf(args[0]);
        double nominalRate = Double.valueOf(args[1]);
        int duration = Integer.valueOf(args[2]);
        LocalDateTime startDate = LocalDateTime.ofInstant(Instant.parse(args[3]), ZoneOffset.UTC);

        // create the request and calculator, and calculate
        AnnuityCalculationRequest req = new AnnuityCalculationRequest(loanAmount, nominalRate, duration, startDate);
        AnnuityCalculator calc = new AnnuityCalculator();
        List<AnnuityPayment> payments = calc.calculateAnnuity(req);

        // map the payments to their json representation and collect in a json array
        JSONArray paymentsJson = payments.stream()
                .map(AnnuityPayment::json)
                .collect(Collector.of(
                        JSONArray::new,
                        JSONArray::put,
                        JSONArray::put));

        // pretty print with 2 space indent
        String jsonString = paymentsJson.toString(2);
        System.out.println(jsonString);
    }
}
