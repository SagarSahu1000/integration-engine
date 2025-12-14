package com.cloudeagle.integration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudeagle.integration.entity.FieldMapping;

public interface FieldMappingRepository
        extends JpaRepository<FieldMapping, Long> {

    List<FieldMapping> findByAppId(Long appId);
}
