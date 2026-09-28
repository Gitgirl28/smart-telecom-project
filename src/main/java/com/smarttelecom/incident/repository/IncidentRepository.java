package com.smarttelecom.incident.repository;

import com.smarttelecom.incident.entity.Incident;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface IncidentRepository extends JpaRepository<Incident,Long> {
    List<Incident> findBySeverity(String severity);
    List<Incident> findByStatus(String status);
    List<Incident> findByServiceName(String serviceName);
    List<Incident> findByErrorCode(String errorCode);
    List<Incident> findBySeverityAndStatus(String severity,String status);
    List<Incident> findBySeverityAndServiceName(String severity,String serviceName);
    List<Incident> findByStatusAndServiceName(String status,String serviceName);
    List<Incident> findBySeverityAndStatusAndServiceName(String severity,String status,String serviceName);

    @Query("SELECT i FROM Incident i WHERE i.severity = :severity AND i.title LIKE %:keyword%")
    List<Incident> findBySeverityAndTitle(@Param("severity") String severity,@Param("keyword") String keyword);

    @Query(value="SELECT * FROM incidents WHERE severity = :severity",nativeQuery=true)
    List<Incident> findBySeverityNative(@Param("severity") String severity);

    Page<Incident> findBySeverity(String severity,Pageable pageable);
    Page<Incident> findByStatus(String status,Pageable pageable);
    Page<Incident> findByServiceName(String serviceName,Pageable pageable);
    Page<Incident> findBySeverityAndStatus(String severity,String status,Pageable pageable);
    Page<Incident> findBySeverityAndServiceName(String severity,String serviceName,Pageable pageable);
    Page<Incident> findByStatusAndServiceName(String status,String serviceName,Pageable pageable);
    Page<Incident> findBySeverityAndStatusAndServiceName(String severity,String status,String serviceName,Pageable pageable);
}