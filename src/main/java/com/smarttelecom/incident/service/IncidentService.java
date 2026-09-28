package com.smarttelecom.incident.service;

import com.smarttelecom.incident.dto.*;
import com.smarttelecom.incident.entity.Incident;
import com.smarttelecom.incident.exception.IncidentNotFoundException;
import com.smarttelecom.incident.mapper.IncidentMapper;
import com.smarttelecom.incident.repository.IncidentRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class IncidentService {
    private final IncidentRepository repo;
    private final IncidentMapper mapper;

    public IncidentService(IncidentRepository repo,IncidentMapper mapper){this.repo=repo;this.mapper=mapper;}

    public IncidentResponse createIncident(IncidentRequest r){return mapper.toResponse(repo.save(mapper.toEntity(r)));}

    public List<IncidentResponse> getAllIncidents(){
        return repo.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    public IncidentResponse getIncidentById(Long id){
        return mapper.toResponse(repo.findById(id).orElseThrow(()->new IncidentNotFoundException("Incident not found with id: "+id)));
    }

    public IncidentResponse updateIncident(Long id,IncidentRequest r){
        Incident i=repo.findById(id).orElseThrow(()->new IncidentNotFoundException("Incident not found with id: "+id));
        mapper.updateEntity(i,r); return mapper.toResponse(repo.save(i));
    }

    public void deleteIncident(Long id){
        if(!repo.existsById(id)) throw new IncidentNotFoundException("Incident not found with id: "+id);
        repo.deleteById(id);
    }

    public List<IncidentResponse> searchIncidents(String severity,String status,String serviceName){
        List<Incident> x;
        if(severity!=null&&status!=null&&serviceName!=null) x=repo.findBySeverityAndStatusAndServiceName(severity,status,serviceName);
        else if(severity!=null&&status!=null) x=repo.findBySeverityAndStatus(severity,status);
        else if(severity!=null&&serviceName!=null) x=repo.findBySeverityAndServiceName(severity,serviceName);
        else if(status!=null&&serviceName!=null) x=repo.findByStatusAndServiceName(status,serviceName);
        else if(severity!=null) x=repo.findBySeverity(severity);
        else if(status!=null) x=repo.findByStatus(status);
        else if(serviceName!=null) x=repo.findByServiceName(serviceName);
        else x=repo.findAll();
        return x.stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    public Page<IncidentResponse> getIncidents(Pageable p){return repo.findAll(p).map(mapper::toResponse);}

    public Page<IncidentResponse> searchIncidents(String severity,String status,String serviceName,Pageable p){
        Page<Incident> x;
        if(severity!=null&&status!=null&&serviceName!=null) x=repo.findBySeverityAndStatusAndServiceName(severity,status,serviceName,p);
        else if(severity!=null&&status!=null) x=repo.findBySeverityAndStatus(severity,status,p);
        else if(severity!=null&&serviceName!=null) x=repo.findBySeverityAndServiceName(severity,serviceName,p);
        else if(status!=null&&serviceName!=null) x=repo.findByStatusAndServiceName(status,serviceName,p);
        else if(severity!=null) x=repo.findBySeverity(severity,p);
        else if(status!=null) x=repo.findByStatus(status,p);
        else if(serviceName!=null) x=repo.findByServiceName(serviceName,p);
        else x=repo.findAll(p);
        return x.map(mapper::toResponse);
    }
}