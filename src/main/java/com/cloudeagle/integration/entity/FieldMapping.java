package com.cloudeagle.integration.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FieldMapping {

    @Id
    private Long id;

    private String sourcePath;
    private String targetField;

    public String getSourcePath() {
        return sourcePath;
    }

    public String getTargetField() {
        return targetField;
    }
}
