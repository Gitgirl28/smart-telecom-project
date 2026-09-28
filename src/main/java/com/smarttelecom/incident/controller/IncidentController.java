package com.smarttelecom.incident.controller;

import com.smarttelecom.incident.dto.*;
import com.smarttelecom.incident.service.IncidentService;
import jakarta.validation.Valid;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {
    private final IncidentService service;
    public IncidentController(IncidentService service){this.service=service;}

    @PostMapping
    public ResponseEntity<IncidentResponse> create(@Valid @RequestBody IncidentRequest r){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createIncident(r));
    }
    @GetMapping
    public ResponseEntity<List<IncidentResponse>> getAll(){return ResponseEntity.ok(service.getAllIncidents());}
    @GetMapping("/{id}")
    public ResponseEntity<IncidentResponse> getById(@PathVariable Long id){return ResponseEntity.ok(service.getIncidentById(id));}
    @PutMapping("/{id}")
    public ResponseEntity<IncidentResponse> update(@PathVariable Long id,@Valid @RequestBody IncidentRequest r){return ResponseEntity.ok(service.updateIncident(id,r));}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){service.deleteIncident(id);return ResponseEntity.noContent().build();}

    @GetMapping("/search")
    public ResponseEntity<List<IncidentResponse>> search(
            @RequestParam(required=false) String severity,
            @RequestParam(required=false) String status,
            @RequestParam(required=false) String serviceName){
        return ResponseEntity.ok(service.searchIncidents(severity,status,serviceName));
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<IncidentResponse>> paged(Pageable pageable){return ResponseEntity.ok(service.getIncidents(pageable));}

    @GetMapping("/search/paged")
    public ResponseEntity<Page<IncidentResponse>> searchPaged(
            @RequestParam(required=false) String severity,
            @RequestParam(required=false) String status,
            @RequestParam(required=false) String serviceName,
            Pageable pageable){
        return ResponseEntity.ok(service.searchIncidents(severity,status,serviceName,pageable));
    }
}