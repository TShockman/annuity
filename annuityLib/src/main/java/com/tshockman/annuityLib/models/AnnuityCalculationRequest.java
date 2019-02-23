package com.tshockman.annuityLib.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class AnnuityCalculationRequest {
    private double loanAmount;
    private double nominalRate;
    private int duration;
    private LocalDateTime startDate;

    public AnnuityCalculationRequest(double loanAmount, double nominalRate, int duration, LocalDateTime startDate) {
        this.loanAmount = loanAmount;
        this.nominalRate = nominalRate;
        this.duration = duration;
        this.startDate = startDate;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public double getNominalRate() {
        return nominalRate;
    }

    public int getDuration() {
        return duration;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    @Override
    public boolean equals(Object thatObj) {
        if (thatObj.getClass() != this.getClass()) {
            return false;
        }
        AnnuityCalculationRequest that = (AnnuityCalculationRequest) thatObj;
        return this.loanAmount == that.getLoanAmount()
                && this.nominalRate == that.getNominalRate()
                && this.duration == that.getDuration()
                && this.startDate.equals(that.getStartDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.loanAmount, this.nominalRate, this.duration, this.startDate);
    }


}
