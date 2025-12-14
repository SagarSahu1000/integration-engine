package com.cloudeagle.integration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudeagle.integration.entity.ExternalApp;

public interface ExternalAppRepository extends JpaRepository<ExternalApp, Long> {
}
