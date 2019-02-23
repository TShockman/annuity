package com.tshockman.annuityLib.models;

import org.json.JSONObject;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

public class AnnuityPayment {

    private double borrowerPaymentAmount;
    private LocalDateTime date;
    private double initialOutstandingPrincipal;
    private double interest;
    private double principal;
    private double remainingOutstandingPrincipal;

    private JSONObject asJson;

    public AnnuityPayment(double borrowerPaymentAmount, LocalDateTime date, double initialOutstandingPrincipal, double interest, double principal, double remainingOutstandingPrincipal) {
        this.borrowerPaymentAmount = borrowerPaymentAmount;
        this.date = date;
        this.initialOutstandingPrincipal = initialOutstandingPrincipal;
        this.interest = interest;
        this.principal = principal;
        this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
        this.asJson = generateJson();
    }

    private JSONObject generateJson() {
        DecimalFormat df = new DecimalFormat("#0.00");
        return new JSONObject()
                .put("borrowerPaymentAmount", df.format(this.borrowerPaymentAmount))
                .put("date", date.toString())
                .put("initialOutstandingPrincipal", df.format(this.initialOutstandingPrincipal))
                .put("interest", df.format(this.interest))
                .put("principal", df.format(this.principal))
                .put("remainingOutstandingPrincipal", df.format(this.remainingOutstandingPrincipal));
    }

    public double getBorrowerPaymentAmount() {
        return borrowerPaymentAmount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public double getInitialOutstandingPrincipal() {
        return initialOutstandingPrincipal;
    }

    public double getInterest() {
        return interest;
    }

    public double getPrincipal() {
        return principal;
    }

    public double getRemainingOutstandingPrincipal() {
        return remainingOutstandingPrincipal;
    }

    public JSONObject json() {
        return this.asJson;
    }
}
