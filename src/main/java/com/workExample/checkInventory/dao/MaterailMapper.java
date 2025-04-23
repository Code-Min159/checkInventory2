package com.workExample.checkInventory.dao;

import com.workExample.checkInventory.dataObject.Material;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MaterailMapper {

    //查詢所有原料
    List<Material> findAll();

    //查詢單一原料
    @Select("SELECT * FROM material where id = #{id}")
    Material getById(@Param("id") String id);

    //查詢單一原料
    @Select("SELECT * FROM material where name = #{name}")
    Material getByName(@Param("name") String name);

    //查詢所有原料
    @Select("SELECT * FROM material")
    @Results({@Result(property = "isOutOfDate", column = "is_out_of_date"),
              @Result(property = "isFoodAddtives", column = "is_food_addtives"),
              @Result(property = "isFoodAllergen", column = "is_food_allergen")})
    List<Material> getAllMaterials();

    //新增原料
    @Insert("INSERT INTO material (id, name, effective_date, weight, is_out_of_date, is_food_addtives, location, description) " +
            "VALUES (#{id}, #{name}, #{effectiveDate}, #{weight}, #{isOutOfDate}, #{isFoodAddtives}, #{location}, #{description})")
    @Options(useGeneratedKeys = true, keyProperty = "id")//新增資料的時候，透過這個方法自動帶入ID(會自己計算)
    void insert(Material material);

    //更新原料
    @Update("UPDATE material SET name = #{name}, effective_date = #{effectiveDate}, weight = #{weight}, " +
            "is_out_of_date = #{isOutOfDate}, is_food_addtives = #{isFoodAddtives}, is_food_allergen = #{isFoodAllergen}, " +
            "location = #{location}, description = #{description} " +
            "WHERE id = #{id}")
    void updateMaterial(Material material);

    //刪除原料
    @Delete("DELETE FROM material WHERE id = #{id}")
    void deleteMaterial(String id);


    //查詢食品添加物
    @Select("SELECT * FROM material WHERE is_food_addtives = #{isFoodAddtives}")
    List<Material> searchFoodAddtives(boolean isFoodAddtives);

    //查詢過敏原
    @Select("SELECT * FROM material WHERE is_food_allergen = #{isFoodAllergen}")
    List<Material> searchFoodAllergen(boolean isFoodAllergen);

}
