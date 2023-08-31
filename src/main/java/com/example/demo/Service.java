package com.example.demo;

import java.time.Duration;
import java.time.LocalDateTime;

@org.springframework.stereotype.Service
public class Service {
    private final SegmentRepository segmentRepository;
    private final CustomerInfoRepository customerInfoRepository;
    private final FulfillmentRepository fulfillmentRepository;
    private final OfferCategoryRepository offerCategoryRepository;
    public Service(SegmentRepository segmentRepository, CustomerInfoRepository customerInfoRepository, FulfillmentRepository fulfillmentRepository, OfferCategoryRepository offerCategoryRepository) {
        this.segmentRepository = segmentRepository;
        this.customerInfoRepository = customerInfoRepository;
        this.fulfillmentRepository = fulfillmentRepository;
        this.offerCategoryRepository = offerCategoryRepository;
    }
    public CustomerInfoModel getInfo(String msisdn){
        return customerInfoRepository.findCustomerInfoModelByMsisdn(msisdn);
    }
    public void addGift(String msisdn,int offerId) {
        OfferCategoryModel offerCategoryModel=offerCategoryRepository.findOfferCategoryModelByOfferId(offerId);//GETS OFFER
        CustomerInfoModel customerInfoModel = customerInfoRepository.findCustomerInfoModelByMsisdn(msisdn);//GETS THE CUSTOMER
        int segmentId=customerInfoModel.getSegmentId();
        SegmentModel segmentModel = segmentRepository.findSegmentModelBySegmentIdAndOfferId(segmentId,offerId);
        if(segmentModel==null){
            System.out.println("offer is not eligible for this segment");
            return;
        }
        int offerCap=offerCategoryModel.getOfferCap();
        int segmentCap=offerCap/5;
        int segmentCounter= segmentModel.getSegmentCounter();
        int offerCount=offerCategoryModel.getOfferCount();
        if(offerCount>=offerCap){
            System.out.println("Offer cap is reached");
            return;
        }

        if(segmentCounter>=segmentCap){//CHECKS THE CAPPING
            System.out.println("Segment cap is reached");
            return;
        }
        FulfillmentModel fulfillmentModel=fulfillmentRepository.findFulfillmentModelByMsisdnAndAndOfferId(msisdn,offerId);
        if(fulfillmentModel!=null){
            if(Duration.between(fulfillmentModel.getLastActionDate(),LocalDateTime.now()).toHours()<72){
                System.out.println("Duration less than 3 days");
                return;
            }
        }
        customerInfoRepository.updateGiftCount(customerInfoModel.getGiftCount()+1,msisdn);//increment gift count
        offerCategoryRepository.incrementOfferCount(offerCategoryModel.getOfferCount()+1,offerCategoryModel.getOfferId());
        fulfillmentRepository.insertFulfillment(msisdn,(msisdn.charAt(9))+"",LocalDateTime.now(),offerId);
        segmentRepository.incrementSegmentCounter(segmentId,segmentCounter+1,offerId);
        System.out.println("Fulfilled");
    }
}
