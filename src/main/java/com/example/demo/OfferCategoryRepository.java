package com.example.demo;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface OfferCategoryRepository extends CrudRepository<OfferCategoryModel,Integer> {
    OfferCategoryModel findOfferCategoryModelByOfferId(int offerId);

    @Modifying
    @Query("UPDATE OFFER_CATEGORY SET OFFER_COUNT=:offerCount where OFFER_ID=:offerId")
    void incrementOfferCount(int offerCount, int offerId);

    @Modifying
    @Query("UPDATE OFFER_CATEGORY SET OFFER_COUNT=:offerCount where OFFER_ID=:offerId")
    void decrementOfferCount(int offerCount, int offerId);

    @Query("SELECT * FROM OFFER_CATEGORY")
    Stream<OfferCategoryModel> findAllStream();

}