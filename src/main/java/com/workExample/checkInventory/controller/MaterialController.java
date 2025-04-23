package com.workExample.checkInventory.controller;

import com.workExample.checkInventory.dataObject.ApiResponse;
import com.workExample.checkInventory.dataObject.Material;
import com.workExample.checkInventory.server.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class MaterialController {
    /***
     * Controller is catch front-end input data and defind API method
     */

    @Autowired
    private MaterialService materialService;

    /***
     * Material
     * CRUD
     */
    //查詢所有原料
    @GetMapping("api/getAllMaterails")
    public ApiResponse<List<Material>> getAllMaterials(){
        ApiResponse<List<Material>> response = new ApiResponse<>();
        try{
            List<Material> materials = materialService.getAllMaterials();
            response.setData(materials);
            response.setStasus(HttpStatusCode.valueOf(200));
            return response;
        } catch (Exception e) {
            response.setStasus(HttpStatusCode.valueOf(500));
            response.setMessage(e.getMessage());
        }
        return response;
    }

//    //用品號查
//    //用名稱查


    @PostMapping("api/materail")
    public ApiResponse<Material> createMaterial(@RequestBody Material request){
        //@RequestBody 指POST 方法帶進來的參數

        ApiResponse<Material> response = new ApiResponse<>();
        try{
            Material new_material = materialService.createMaterial(request.getId(),request.getName(), request.getEffectiveDate(),
                                                                request.getWeight(),request.isOutOfDate(), request.isFoodAddtives(),
                                                                request.isFoodAllergen(), request.getLocation(), request.getDescription());
            response.setData(new_material);
            response.setStasus(HttpStatusCode.valueOf(200));
            return response;
        } catch (Exception e) {
            response.setStasus(HttpStatusCode.valueOf(500));
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @DeleteMapping("api/materail/{id}")
    public ApiResponse<String> deleteMaterial(@PathVariable("id") String id){
        ApiResponse<String> response = new ApiResponse<>();
        try{
            Material deleteMaterial = materialService.getMaterialById(id);
            if(!Objects.nonNull(deleteMaterial)){
                response.setData("delete fail, id :" +id +"is not exist");
            }
            String result = materialService.deleteMaterial(id);
            response.setData(result);
            response.setStasus(HttpStatusCode.valueOf(200));
            return response;
        } catch (Exception e) {
            response.setStasus(HttpStatusCode.valueOf(500));
            response.setMessage(e.getMessage());
        }
        return response;
    }
    @PutMapping("api/materail/{id}")
    public ApiResponse<Material> upMaterel(@PathVariable("id") String id, @RequestBody Material request){
        ApiResponse<Material> response = new ApiResponse<>();
        try{
            Material upMaterel = materialService.updateMaterial(id,request.getName(), request.getWeight(), request.getEffectiveDate(),
                                                                request.isOutOfDate(), request.isFoodAddtives(),
                                                                request.isFoodAllergen(), request.getLocation(), request.getDescription());
            response.setData(upMaterel);
            response.setStasus(HttpStatusCode.valueOf(200));
            return response;
        } catch (Exception e) {
            response.setStasus(HttpStatusCode.valueOf(500));
            response.setMessage(e.getMessage());
        }
        return response;
    }

    // 查食品添加物
    @GetMapping("api/materail/searchFoodAddtives")
    public ApiResponse<List<Material>> searchFoodAddtives(){
        ApiResponse<List<Material>> response = new ApiResponse<>();
        try{

            List<Material> foodAddtives = materialService.searchFoodAddtives(true);
            response.setData(foodAddtives);
            response.setStasus(HttpStatusCode.valueOf(200));
            return response;
        } catch (Exception e) {
            response.setStasus(HttpStatusCode.valueOf(500));
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @GetMapping("api/materail/searchFoodAllergen")
    public ApiResponse<List<Material>> searchFoodAllergen(){
        ApiResponse<List<Material>> response = new ApiResponse<>();
        try{

            List<Material> foodAllergen = materialService.searchFoodAllergen(true);
            response.setData(foodAllergen);
            response.setStasus(HttpStatusCode.valueOf(200));
            return response;
        } catch (Exception e) {
            response.setStasus(HttpStatusCode.valueOf(500));
            response.setMessage(e.getMessage());
        }
        return response;
    }







//    public Material searchEffectiveDate(){
//
//    }
//
//    public Integer caculationAmountBySchedule(){
//
//    }
//
//    public Integer caculationInventory(){
//
//    }
//
//
//    public List<Material> searchDanagerMaterail(){
//
//    }





}
