package com.workExample.checkInventory.server;


import com.workExample.checkInventory.dao.MaterailMapper;
import com.workExample.checkInventory.dataObject.Material;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MaterialService {

    private final MaterailMapper materailMapper; //sql+Mapper查詢使用
    //建構子:再啟動MaterialService的時候，初始化一些設定
    public MaterialService(MaterailMapper materailMapper){
        this.materailMapper = materailMapper;
    }


    /***
     * create material
     * @return
     */

    //查詢所有原料
    public List<Material> getAllMaterials(){
        List<Material> materials = materailMapper.getAllMaterials();
        return materials;
    }

    // 取得原料
    public Material getMaterialById(String id){
        Material material = materailMapper.getById(id);

        //判斷從資料庫回來有沒有東西
        if(!Objects.nonNull(material)){
            System.out.println("id :" +id +"is not exist");
            return null;
        }
        return material;
    }

//    // 取得原料  名稱用模糊查詢

    //create material
    public Material createMaterial(String id, String name, Integer effectiveDate, double weight,
                                   boolean isOutOfDate, boolean isFoodAddtives, boolean isFoodAllergn, String location, String description)
            throws Exception {
        Material materel = new Material();
        materel.setId(id);
        materel.setName(name);
        materel.setWeight(weight);
        materel.setEffectiveDate(effectiveDate);
        materel.setOutOfDate(isOutOfDate);
        materel.setFoodAddtives(isFoodAddtives);
        materel.setFoodAllergen(isFoodAllergn);
        materel.setLocation(location);
        materel.setDescription(description);
        materailMapper.insert(materel);
        return materel;
    }

    // disable materail (停用:原料之後不使用)
    public String deleteMaterial(String id){
        materailMapper.deleteMaterial(id);
        return "delete success";
    }

    // update Materail
    // 只有 名稱、重量可以改，其他的再新增的時候就要確定，不然就是要開放使用者一些權限去做權限相對應的事(同一個原料有可能會有多個不同的重量)
    // 有效日期輸入錯誤的情況能不能在這邊更改?還是要另外寫一個function去做
    public Material updateMaterial(String id, String name, double weight, Integer effectivedate, boolean isOutOfDate,
                                   boolean isFoodAddtivies, boolean isFoodAllergen, String description, String location) throws Exception {
        // 先查詢資料庫有沒有這個原料
        Material existing_material = materailMapper.getById(id);
        if(existing_material == null) {
            throw new Exception("Material is not exist");
        }
        existing_material.setId(id);
        existing_material.setName(name);
        existing_material.setWeight(weight);
        existing_material.setEffectiveDate(effectivedate);
        existing_material.setOutOfDate(isOutOfDate);
        existing_material.setFoodAddtives(isFoodAddtivies);
        existing_material.setFoodAllergen(isFoodAllergen);
        existing_material.setDescription(description);
        existing_material.setLocation(location);
        materailMapper.updateMaterial(existing_material);
        return existing_material;
    }


    /***
     * 查詢食品添加物
     * @return
     */
    public List<Material> searchFoodAddtives(boolean isFoodAddtives){
        List<Material> foodAddtives = materailMapper.searchFoodAddtives(isFoodAddtives);
        return foodAddtives;
    }

    /***
     * 查詢過敏原
     * @return
     */
    public List<Material> searchFoodAllergen(boolean isFoodAllergen){
        List<Material> foodAllergen = materailMapper.searchFoodAllergen(isFoodAllergen);
        return foodAllergen;
    }



//    /***
//     * 依照排程計算未來使用數量
//     * @return
//     */
//    public Integer caculationAmountBySchedule(File inputFile){
//
//    }
//
//    /***
//     * 輸入目前庫存計算剩餘庫存數量
//     * @return
//     */
//    public Integer caculationInventory(int number){
//
//    }
//

//
//    /***
//     * 過期品、即期品顯示清單
//     * @return
//     */
//    public List<Material> searchDanagerMaterail(){
//
//    }
//




























}
