package com.workExample.checkInventory.dao;


import com.workExample.checkInventory.dataObject.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("SELECT * FROM product WHERE name = #{name}")
    Product searchProductByName(@Param("name") String name);

    Product getProducWithMaterials(String id);

    void addMaterial(String productId, String materialId);

    @Insert("INSERT INTO product (id, name, unit, description, category, supplier, location, safe_stock, is_food_addtives, is_food_allergen) " +
            "VALUES (#{id}, #{name}, #{unit}, #{description}, #{category}, #{supplier}, #{location}, #{safeStock}, #{isFoodAddtives}, #{isFoodAllergen})")
    void createProduct(Product newProduct);

    Product updateProduct(Product updatedProduct);

    @Delete("DELETE FROM product WHERE id = #{id}")
    String deleteProduct(String id);

    @Select("SELECT * FROM product")
    List<Product> getAllProduct();

    @Select("SELECT id FROM product  WHERE id = #{id}")
    Product searchProductById(@Param("id") String id);

}
