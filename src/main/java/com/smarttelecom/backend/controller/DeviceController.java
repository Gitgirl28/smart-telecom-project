package com.smarttelecom.backend.controller;

import com.smarttelecom.backend.model.Device;
import com.smarttelecom.backend.service.DeviceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceController {
    private final DeviceService deviceService;
    public DeviceController(DeviceService deviceService){
        this.deviceService = deviceService;
    }
    @GetMapping
    public List<Device> getAllDevices(){
        return deviceService.getAllDevices();
    }
    @GetMapping("/{id}")
    public List<Device> getAllDevicesById(@PathVariable Long id){
        return deviceService.getDeviceById(id);
    }
}
