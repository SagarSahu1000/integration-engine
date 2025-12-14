package com.cloudeagle.integration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudeagle.integration.entity.TempUser;

public interface TempUserRepository extends JpaRepository<TempUser, Long> {
}
