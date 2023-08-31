package com.example.demo;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface SegmentRepository extends CrudRepository<SegmentModel,Integer> {
    List<SegmentModel> findSegmentModelBySegmentId(int segmentId);
    @Modifying
    @Query("UPDATE SEGMENT SET SEGMENT_COUNTER=:segmentCounter WHERE SEGMENT_ID=:segmentId AND OFFER_ID=:offerId ")
    void incrementSegmentCounter(int segmentId,int segmentCounter,int offerId);
    SegmentModel findSegmentModelBySegmentIdAndOfferId(int segmentId,int offerId);

    @Query("SELECT * FROM SEGMENT")
    Stream<SegmentModel> findAllStream();
}
