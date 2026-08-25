package com.smarttelecom.backend.service;

import com.smarttelecom.backend.model.Device;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceService {
    private final List<Device> devices = new ArrayList<>();
    public DeviceService(){
        devices.add(new Device(1L, "iphone 17", "Apple", 789, "Available"));
        devices.add(new Device(1L, "iphone 14 plus", "Apple", 7097, "Available"));
        devices.add(new Device(2L, "iphone 16", "Apple", 890, "Not Available"));
    }
    public List<Device> getAllDevices(){
        return devices;
    }
    public  List<Device> getDeviceById(Long id){
        return devices.stream()
                .filter(device -> device.getId().equals(id))
                .collect(Collectors.toList());
    }
}
