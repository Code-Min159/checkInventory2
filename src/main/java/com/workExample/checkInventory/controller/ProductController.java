package com.workExample.checkInventory.controller;

import com.workExample.checkInventory.dataObject.ApiResponse;
import com.workExample.checkInventory.dataObject.Product;
import com.workExample.checkInventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {


    @Autowired
    private ProductService productService;

    //新增
    @PostMapping("api/createProduct")
    public ApiResponse<Product> createProduct(@RequestBody Product request) {
        final ApiResponse<Product> response = new ApiResponse<>();
        try {
            Product newProduct = productService.createProduct(request.getId(), request.getName(), request.getUnit(),
                    request.getDescription(), request.getCategory(), request.getSupplier(), request.getLocation(),
                    request.getSafeStock(), request.isFoodAddtives(), request.isFoodAllergen());
            response.setData(newProduct);
            response.setStasus(HttpStatusCode.valueOf(200));
            return response;
        } catch (Exception e) {
            response.setStasus(HttpStatusCode.valueOf(500));
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @PutMapping("api/upProduct/{id}")
    public Product upProduct(@RequestBody Product request, @PathVariable String id) {
        // @RequestBody 指PUT 方法帶進來的參數
        // @PathVariable 指URL帶進來的參數
        Product updatedProduct = productService.upProduct(id, request.getName(), request.getUnit(),
                request.getDescription(), request.getCategory(), request.getSupplier(), request.getLocation(),
                request.getSafeStock(), request.isFoodAddtives(), request.isFoodAllergen());
        return updatedProduct;

    }
    //ok
    @DeleteMapping("api/deleteProduct/{id}")
    public ApiResponse<String> deleteProduct(@PathVariable String id) {
        ApiResponse<String> response = new ApiResponse<>();
        try {
            String result = productService.deleteProduct(id);
            response.setData(result);
            response.setStasus(HttpStatusCode.valueOf(200));
            return response;
        } catch (Exception e) {
            response.setStasus(HttpStatusCode.valueOf(500));
            response.setMessage(e.getMessage());
        }
        return response;
    }

    //查詢 ok
    @GetMapping("api/getAllProduct")
    public ApiResponse<List<Product>> getAllProduct() {
        final ApiResponse<List<Product>> response = new ApiResponse<>();
        try {
            final List productList = productService.getAllProduct();
            response.setData(productList);
            response.setStasus(HttpStatusCode.valueOf(200));
            return response;
        } catch (Exception e) {
            response.setStasus(HttpStatusCode.valueOf(500));
            response.setMessage(e.getMessage());
        }
        return response;
    }

    //查詢-依編號
    @GetMapping("api/searchProduct/{id}")
    public ApiResponse<Product> searchProductById(@PathVariable String id) {
        final ApiResponse<Product> response = new ApiResponse<>();
        try {
            final Product product = productService.searchProductById(id);
            response.setData(product);
            response.setStasus(HttpStatusCode.valueOf(200));
            return response;
        } catch (Exception e) {
            response.setStasus(HttpStatusCode.valueOf(500));
            response.setMessage(e.getMessage());
        }
        return response;
    }
    //查詢-依名稱
    @GetMapping("api/getProductWithMaterials/{name}")
    public ApiResponse<Product> getProductByName(@PathVariable String name) {
        final ApiResponse<Product> response = new ApiResponse<>();
        try {
            final Product product = productService.getProductByName(name);
            response.setData(product);
            response.setStasus(HttpStatusCode.valueOf(200));
            return response;
        } catch (Exception e) {
            response.setStasus(HttpStatusCode.valueOf(500));
            response.setMessage(e.getMessage());
        }
        return response;
    }


//    //查詢庫存量



//    //做動態查詢
//    @GetMapping("api/product/{id}")
//    public Product searchProduct(){
//
//    }


    //取得產品有使用哪些原料
    @GetMapping("api/product/{id}")
    public ApiResponse<Product> getProduct(@PathVariable("id") String id) {
        final ApiResponse<Product> response = new ApiResponse<>();
        try {
            final Product product = productService.getById(id);
            response.setData(product);
            response.setStasus(HttpStatusCode.valueOf(200));
            return response;
        } catch (Exception e) {
            response.setStasus(HttpStatusCode.valueOf(500));
            response.setMessage(e.getMessage());
        }
        return response;

    }




}
