package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("OFFER_CATEGORY")
public class OfferCategoryModel {
    @Id
    int offerId;
    String offerName;
    int offerCount;
    int offerCap;

    public OfferCategoryModel(int offerId, String offerName, int offerCount,int offerCap) {
        this.offerId = offerId;
        this.offerName = offerName;
        this.offerCount = offerCount;
        this.offerCap=offerCap;
    }

    public int getOfferCap() {
        return offerCap;
    }

    public void setOfferCap(int offerCap) {
        this.offerCap = offerCap;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public int getOfferCount() {
        return offerCount;
    }

    public void setOfferCount(int offerCount) {
        this.offerCount = offerCount;
    }
}
