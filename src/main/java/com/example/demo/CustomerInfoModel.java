package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("CUSTOMER_INFO")
public class CustomerInfoModel {
    @Id
    String msisdn;
    String name;
    int giftCount;
    int segmentId;

    public CustomerInfoModel(String msisdn, String name, int giftCount,int segmentId) {
        this.msisdn = msisdn;
        this.name = name;
        this.giftCount = giftCount;
        this.segmentId=segmentId;
    }

    public int getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(int segmentId) {
        this.segmentId = segmentId;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGiftCount() {
        return giftCount;
    }

    public void setGiftCount(int giftCount) {
        this.giftCount = giftCount;
    }
}
