package com.multiagents.pmds.repository;

import com.multiagents.pmds.models.SampleSync;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SampleSyncRepository extends JpaRepository<SampleSync, Long> {
    Optional<SampleSync> findBySampleKey(String sampleKey);

    Boolean existsBySampleKey(String sampleKey);

    Boolean existsBySampleValue(String sampleValue);
}