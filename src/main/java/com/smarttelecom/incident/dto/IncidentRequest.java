package com.smarttelecom.incident.dto;

import jakarta.validation.constraints.NotBlank;

public class IncidentRequest {
    @NotBlank(message="Title is required") private String title;
    @NotBlank(message="Description is required") private String description;
    @NotBlank(message="Service name is required") private String serviceName;
    @NotBlank(message="Error code is required") private String errorCode;
    @NotBlank(message="Severity is required") private String severity;
    @NotBlank(message="Status is required") private String status;

    public String getTitle(){return title;} public void setTitle(String v){title=v;}
    public String getDescription(){return description;} public void setDescription(String v){description=v;}
    public String getServiceName(){return serviceName;} public void setServiceName(String v){serviceName=v;}
    public String getErrorCode(){return errorCode;} public void setErrorCode(String v){errorCode=v;}
    public String getSeverity(){return severity;} public void setSeverity(String v){severity=v;}
    public String getStatus(){return status;} public void setStatus(String v){status=v;}
}