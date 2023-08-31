package com.example.demo;

import org.springframework.data.relational.core.mapping.Table;

@Table("SEGMENT")
public class SegmentModel {
    int segmentId;
    int segmentCounter;
    int offerId;

    public SegmentModel(int segmentId, int segmentCounter,int offerId) {
        this.segmentId = segmentId;
        this.segmentCounter = segmentCounter;
        this.offerId=offerId;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public int getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(int segmentId) {
        this.segmentId = segmentId;
    }

    public int getSegmentCounter() {
        return segmentCounter;
    }

    public void setSegmentCounter(int segmentCounter) {
        this.segmentCounter = segmentCounter;
    }

}
