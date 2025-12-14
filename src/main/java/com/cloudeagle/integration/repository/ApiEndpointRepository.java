package com.cloudeagle.integration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudeagle.integration.entity.ApiEndpoint;

public interface ApiEndpointRepository
        extends JpaRepository<ApiEndpoint, Long> {

    Optional<ApiEndpoint> findByAppIdAndName(Long appId, String name);
}
