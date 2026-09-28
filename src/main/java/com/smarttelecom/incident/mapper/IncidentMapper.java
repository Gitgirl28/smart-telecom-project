package com.smarttelecom.incident.mapper;

import com.smarttelecom.incident.dto.*;
import com.smarttelecom.incident.entity.Incident;
import org.springframework.stereotype.Component;

@Component
public class IncidentMapper {
    public IncidentResponse toResponse(Incident i) {
        IncidentResponse r=new IncidentResponse();
        r.setId(i.getId()); r.setTitle(i.getTitle()); r.setDescription(i.getDescription());
        r.setServiceName(i.getServiceName()); r.setErrorCode(i.getErrorCode());
        r.setSeverity(i.getSeverity()); r.setStatus(i.getStatus());
        r.setCreatedAt(i.getCreatedAt()); r.setUpdatedAt(i.getUpdatedAt());
        return r;
    }
    public Incident toEntity(IncidentRequest r) {
        Incident i=new Incident(); updateEntity(i,r); return i;
    }
    public void updateEntity(Incident i, IncidentRequest r) {
        i.setTitle(r.getTitle()); i.setDescription(r.getDescription());
        i.setServiceName(r.getServiceName()); i.setErrorCode(r.getErrorCode());
        i.setSeverity(r.getSeverity()); i.setStatus(r.getStatus());
    }
}