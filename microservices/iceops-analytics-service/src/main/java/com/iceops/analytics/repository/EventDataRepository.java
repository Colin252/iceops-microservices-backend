package com.iceops.analytics.repository;

import com.iceops.analytics.entity.EventData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventDataRepository extends JpaRepository<EventData, Long> {
    // Spring Data se encarga de todo automáticamente
}