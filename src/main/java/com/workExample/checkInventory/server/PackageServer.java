package com.workExample.checkInventory.server;

import com.workExample.checkInventory.dao.PackageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageServer {

    @Autowired
    private PackageMapper packageMapper;

    // Add methods to interact with the packageMapper for CRUD operations
    public List<Package> findAll() {
        return packageMapper.findAll();
    }
    public Package getById(String id) {
        return packageMapper.getById(id);
    }
    public Package createPackage(Package request) {
        // Implement the logic to create a new package
        return packageMapper.createPackage(request);
    }
    public Package updatePackage(Package request) {
        // Implement the logic to update an existing package
        return packageMapper.updatePackage(request);
    }
    public void deletePackage(String id) {
        // Implement the logic to delete a package by id
        packageMapper.deletePackage(id);
    }
    public List<Package> searchByName(String name) {
        // Implement the logic to search packages by name
        return packageMapper.searchByName(name);
    }
}
