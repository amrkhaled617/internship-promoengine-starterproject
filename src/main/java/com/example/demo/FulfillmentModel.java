package com.example.demo;

import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("FULFILLMENT")
public class FulfillmentModel {
    String msisdn;
    String msisdnLastDigit;
    LocalDateTime lastActionDate;
    int offerId;

    public FulfillmentModel(String msisdn, String msisdnLastDigit, LocalDateTime lastActionDate, int offerId) {
        this.msisdn = msisdn;
        this.msisdnLastDigit = msisdnLastDigit;
        this.lastActionDate = lastActionDate;
        this.offerId = offerId;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getMsisdnLastDigit() {
        return msisdnLastDigit;
    }

    public void setMsisdnLastDigit(String msisdnLastDigit) {
        this.msisdnLastDigit = msisdnLastDigit;
    }

    public LocalDateTime getLastActionDate() {
        return lastActionDate;
    }

    public void setLastActionDate(LocalDateTime lastActionDate) {
        this.lastActionDate = lastActionDate;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }
}
