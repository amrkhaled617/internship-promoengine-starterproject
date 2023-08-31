package com.example.demo;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

@Repository
public interface FulfillmentRepository extends CrudRepository<FulfillmentModel,Integer> {
    FulfillmentModel findFulfillmentModelByMsisdnAndAndOfferId(String msisdn,int offerId);

    @Modifying
    @Query("INSERT INTO FULFILLMENT VALUES(:msisdn,:msisdnLastDigit,:lastActionDate,:offerId)")
    void insertFulfillment(String msisdn, String msisdnLastDigit, LocalDateTime lastActionDate,int offerId);

    @Query("SELECT * FROM FULFILLMENT")
    Stream<FulfillmentModel> findAllStream();

    @Query("SELECT * FROM FULFILLMENT WHERE MSISDN=:msisdn and LAST_ACTION_DATE>= NOW() -INTERVAL 72 HOUR")
    List<FulfillmentModel> findFulfillmentModelsInTheLastThreeDays(String msisdn);
}
