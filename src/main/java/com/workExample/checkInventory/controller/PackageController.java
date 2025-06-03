package com.workExample.checkInventory.controller;

import com.workExample.checkInventory.dataObject.ApiResponse;
import com.workExample.checkInventory.dataObject.Material;
import com.workExample.checkInventory.dataObject.Package;
import com.workExample.checkInventory.server.PackageServer;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PackageController {

    private final PackageServer packageServer;

    public PackageController(PackageServer packageServer) {
        this.packageServer = packageServer;
    }

//    @GetMapping("api/package/findAll")
//    public ApiResponse<List<Package>> findAll() {
//        ApiResponse<List<Package>> response = new ApiResponse<>();
//        try {
//            List<Package> materials = packageServer.findAll();
//            response.setData(materials);
//            response.setStasus(HttpStatusCode.valueOf(200));
//            return response;
//        } catch (Exception e) {
//            response.setStasus(HttpStatusCode.valueOf(500));
//            response.setMessage(e.getMessage());
//        }
//        return response;
//    }
//
//    @PostMapping("api/package/{id}")
//    public ApiResponse<Package> getById(@PathVariable("id") String id) {
//        ApiResponse<Package> response = new ApiResponse<>();
//        try {
//            Package packageData = packageServer.getById(id);
//            if (packageData != null) {
//                response.setData(packageData);
//                response.setStasus(HttpStatusCode.valueOf(200));
//                return response;
//            } else {
//                response.setStasus(HttpStatusCode.valueOf(404));
//                response.setMessage("Package not found");
//                return response;
//            }
//        } catch (Exception e) {
//            response.setStasus(HttpStatusCode.valueOf(500));
//            response.setMessage(e.getMessage());
//        }
//        return response;
//    }
//    @PostMapping("api/createPackage")
//    public ApiResponse<Package> createPackage(@RequestBody Package request) {
//        ApiResponse<Package> response = new ApiResponse<>();
//        try {
//            Package newPackage = packageServer.createPackage(request);
//            response.setData(newPackage);
//            response.setStasus(HttpStatusCode.valueOf(200));
//            return response;
//        } catch (Exception e) {
//            response.setStasus(HttpStatusCode.valueOf(500));
//            response.setMessage(e.getMessage());
//        }
//        return response;
//    }
//    @PutMapping("api/updatePackage/{id}")
//    public ApiResponse<Package> updatePackage(@PathVariable("id") String id,@RequestBody Package request) {
//        ApiResponse<Package> response = new ApiResponse<>();
//        try {
//            Package updatedPackage = packageServer.updatePackage(id, request);
//            response.setData(updatedPackage);
//            response.setStasus(HttpStatusCode.valueOf(200));
//            return response;
//        } catch (Exception e) {
//            response.setStasus(HttpStatusCode.valueOf(500));
//            response.setMessage(e.getMessage());
//        }
//        return response;
//    }
//
//    @Delete("api/deletePackage/{id}")
//    public ApiResponse<String> deletePackage(String id) {
//        ApiResponse<String> response = new ApiResponse<>();
//        try {
//            packageServer.deletePackage(id);
//            response.setData("Package deleted successfully");
//            response.setStasus(HttpStatusCode.valueOf(200));
//            return response;
//        } catch (Exception e) {
//            response.setStasus(HttpStatusCode.valueOf(500));
//            response.setMessage(e.getMessage());
//        }
//        return response;
//    }


}
