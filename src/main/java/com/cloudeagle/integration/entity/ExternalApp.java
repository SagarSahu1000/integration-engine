
package com.cloudeagle.integration.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ExternalApp {
 @Id
 private Long id;
 private String name;
 private String baseUrl;
 private String authType;

 public Long getId() { return id; }
 public String getName() { return name; }
 public String getBaseUrl() { return baseUrl; }
 public String getAuthType() { return authType; }
}
