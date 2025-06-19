package com.workExample.checkInventory.service;

import com.workExample.checkInventory.dao.MaterailMapper;
import com.workExample.checkInventory.dao.ProductMapper;
import com.workExample.checkInventory.dataObject.Material;
import com.workExample.checkInventory.dataObject.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    public ProductMapper productMapper;
    private MaterailMapper materailMapper;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    //新增
    public Product createProduct(String id, String name, String unit, String description,
                                 String category, String supplier, String location, int safeStock,
                                 boolean isFoodAddtives, boolean isFoodAllergen) {
//        {
//            "id": "D10100000001",
//                "name": "test A",
//                "unit": "kg",
//                "effectDate": false,
//                "foodAddtives": false,
//                "foodAllergen": true,
//                "description": "testCreate039204",
//                "category": "D",
//                "supplier":  "test",
//                "location":  "test",
//                "safeStock": 550
//        }
//        {
//            "stasus": "INTERNAL_SERVER_ERROR",
//                "message": "Cannot invoke \"com.workExample.checkInventory.dataObject.Product.getId()\" because \"result\" is null",
//                "data": null
//        }

        //驗證前端資料正確性
        if (id == null || id.isEmpty() || name == null || name.isEmpty() || unit == null || unit.isEmpty() ||
            category == null || category.isEmpty() || supplier == null || supplier.isEmpty() ||
            location == null || location.isEmpty() || safeStock < 0) {
            throw new IllegalArgumentException("Invalid product data");
        }
        //檢查是否重複新增
        if(!idExists(id)) {
            throw new IllegalArgumentException("Product ID already exists");
        }
        //檢查id格式
        if (!id.matches("^[BCDZ][0-9]{11}$")) {
            throw new IllegalArgumentException("Product ID must start with B, C, D, or Z followed by 11 digits");
        }
        //檢查類別
        if (!category.matches("^[BCDZ]$")) {
            throw new IllegalArgumentException("Category must be one of B, C, D, or Z");
        }
        //檢查供應商名稱
        if (supplier.length() > 20) {
            throw new IllegalArgumentException("Supplier name cannot exceed 20 characters");
        }
        //檢查位置
        if (location.length() > 10 || !location.matches("^[A-Za-z0-9]{1,10}$")) {
            throw new IllegalArgumentException("Location must be alphanumeric and can not over 10 characters long");
        }
        //檢查安全庫存量
        if (safeStock < 0) {
            throw new IllegalArgumentException("Safe stock cannot be negative");
        }

        //建立新產品物件
        Product newProduct = new Product();
        newProduct.setId(id);
        newProduct.setName(name);
        newProduct.setUnit(unit);
        newProduct.setDescription(description);
        newProduct.setCategory(category);
        newProduct.setSupplier(supplier);
        newProduct.setLocation(location);
        newProduct.setSafeStock(safeStock);
        newProduct.setFoodAddtives(isFoodAddtives);
        newProduct.setFoodAllergen(isFoodAllergen);
        newProduct.setOutOfDate(false); // 新產品默認不過期
        newProduct.setEffectiveDate(null); // 初始有效日期為null

        productMapper.createProduct(newProduct);
        return newProduct;
    }

    //檢查ID是否已存在
    public boolean idExists(String id) {
        Product result = productMapper.searchProductById(id);
        if(result.getId() != null || !result.getId().isEmpty() && result.getId().equals(id)) {
            return true; // ID已存在
        }
        return  false;
    }

    public Product searchProductById(String id) {
        return productMapper.searchProductById(id);
    }

    public Product upProduct(String id, String name, String unit, String description,
                                 String category, String supplier, String location, int safeStock,
                                 boolean isFoodAddtives, boolean isFoodAllergen) {
        if( !idExists(id)) {
            throw new IllegalArgumentException("Product ID does not exist");
        }
        //驗證前端資料正確性
        if (name == null || name.isEmpty() || location == null || location.isEmpty()) {
            throw new IllegalArgumentException("Invalid product data");
        }
        Product upProduct = new Product();
        upProduct.setId(id);
        upProduct.setName(name);
        upProduct.setUnit(unit);
        upProduct.setDescription(description);
        upProduct.setCategory(category);
        upProduct.setSupplier(supplier);
        upProduct.setLocation(location);
        upProduct.setSafeStock(safeStock);
        upProduct.setFoodAddtives(isFoodAddtives);
        upProduct.setFoodAllergen(isFoodAllergen);
        upProduct.setOutOfDate(false); // 更新產品默認不過期
        upProduct.setEffectiveDate(null); // 更新有效日期為null
        productMapper.updateProduct(upProduct);
        return upProduct;
    }

    public String deleteProduct(String productId){
        if(idExists(productId)) {
            productMapper.deleteProduct(productId);
            return "Product deleted successfully";
        } else {
            throw new IllegalArgumentException("Product ID does not exist");
        }
    }

    //用名稱查詢
    public Product getProductByName(String name) {
        return productMapper.searchProductByName(name);
    }

    public List<Product> getAllProduct() {
        return productMapper.getAllProduct();
    }



    public Product getById(String id) {
        return productMapper.getProducWithMaterials(id);
    }

    public void addMaterial(String productId, String materialId) {
        Product product = productMapper.getProducWithMaterials(productId);
        if (product == null) {
            throw new IllegalArgumentException("Product not found");
        }
        Material material = materailMapper.getById(materialId);
        if( material == null) {
            throw new IllegalArgumentException("Material not found");
        }
        // 假設這裡添加原料成功
        productMapper.addMaterial(productId, materialId);
    }




}
