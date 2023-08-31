package com.example.demo;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface CustomerInfoRepository extends CrudRepository<CustomerInfoModel,String> {
    CustomerInfoModel findCustomerInfoModelByMsisdn(String msisdn);
    @Modifying
    @Query("UPDATE CUSTOMER_INFO SET GIFT_COUNT=:giftCount WHERE MSISDN=:msisdn")
    void updateGiftCount(int giftCount,String msisdn);


    @Query("SELECT * FROM CUSTOMER_INFO")
    Stream<CustomerInfoModel> findAllStream();

    //    @Modifying
//    @Query ("UPDATE CUSTOMER_INFO SET OFFER_ID=:offerId where MSISDN=:msisdn")
//    void updateOfferId(int offerId,String msisdn);
}
