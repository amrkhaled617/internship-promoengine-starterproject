package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
@EnableScheduling
public class Scheduler {
    CustomerInfoRepository customerInfoRepository;
    OfferCategoryRepository offerCategoryRepository;
    FulfillmentRepository fulfillmentRepository;
    Logger logger = LoggerFactory.getLogger(LoggingController.class);
    SegmentRepository segmentRepository;

    public Scheduler(CustomerInfoRepository customerInfoRepository, OfferCategoryRepository offerCategoryRepository, FulfillmentRepository fulfillmentRepository, SegmentRepository segmentRepository) {
        this.customerInfoRepository = customerInfoRepository;
        this.offerCategoryRepository = offerCategoryRepository;
        this.fulfillmentRepository = fulfillmentRepository;
        this.segmentRepository = segmentRepository;
    }

    //    @Scheduled(fixedDelay = 1000*60,initialDelay = 1)
    public void resetGiftCount() {
        System.out.println("scheduling");
        Iterable<CustomerInfoModel> all = customerInfoRepository.findAll();

        //all.forEach(customerInfoModel -> customerInfoModel.setGiftCount(0));
        all.forEach(customerInfoModel -> {
            customerInfoModel.setGiftCount(0);
            customerInfoRepository.save(customerInfoModel);
        });

    }
    @Scheduled(fixedDelay = 1000*60*10,initialDelay = 1)
    public void logAvailableOffers() {
        Stream<CustomerInfoModel> customerInfoModelStream = customerInfoRepository.findAllStream();
        customerInfoModelStream.forEach(this::logAvailableOffersHepler);
    }

    public void logAvailableOffersHepler(CustomerInfoModel customerInfoModel) {
        int segmentId = customerInfoModel.getSegmentId();
        List<Integer> offersNotAvailable = new ArrayList<>();
        List<SegmentModel> segmentModels = segmentRepository.findSegmentModelBySegmentId(segmentId);
        List<FulfillmentModel> fulfillmentModels = fulfillmentRepository.findFulfillmentModelsInTheLastThreeDays(customerInfoModel.getMsisdn());
        for (SegmentModel segmentModel : segmentModels){
            for (FulfillmentModel fulfillmentModel : fulfillmentModels){
                if(segmentModel.getOfferId()==fulfillmentModel.getOfferId()){
                    offersNotAvailable.add(fulfillmentModel.getOfferId());
                }

                }
            if(!(offersNotAvailable.contains(segmentModel.getOfferId()))){
                logger.info("Customer" + customerInfoModel.getMsisdn() + " has offer" + segmentModel.getOfferId() + " available");
            }

        }

    }



}



