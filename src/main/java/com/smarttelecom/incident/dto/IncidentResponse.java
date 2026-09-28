package com.smarttelecom.incident.dto;

import java.time.LocalDateTime;

public class IncidentResponse {
    private Long id; private String title; private String description;
    private String serviceName; private String errorCode; private String severity; private String status;
    private LocalDateTime createdAt; private LocalDateTime updatedAt;

    public Long getId(){return id;} public void setId(Long v){id=v;}
    public String getTitle(){return title;} public void setTitle(String v){title=v;}
    public String getDescription(){return description;} public void setDescription(String v){description=v;}
    public String getServiceName(){return serviceName;} public void setServiceName(String v){serviceName=v;}
    public String getErrorCode(){return errorCode;} public void setErrorCode(String v){errorCode=v;}
    public String getSeverity(){return severity;} public void setSeverity(String v){severity=v;}
    public String getStatus(){return status;} public void setStatus(String v){status=v;}
    public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime v){createdAt=v;}
    public LocalDateTime getUpdatedAt(){return updatedAt;} public void setUpdatedAt(LocalDateTime v){updatedAt=v;}
}