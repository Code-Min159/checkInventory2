package com.workExample.checkInventory.dataObject;

import lombok.Data;

import java.util.List;

@Data
public class Product {

    private List<Material> materialList; //原料清單 //
    //新增
    private String id;      //編號  1個英文字母(B:原料、C:成品、D:半成品、Z:包材)+11碼數字  EX: C101000001
    private String name;    //名稱
    private String unit; //重量單位  (20250521新增置資料庫設計表)
    private String description; //規格描述
    private String category; //原料類別  (B:原料、C:成品、D:半成品、Z:包材) (20250521新增置資料庫設計表)
    private String supplier; //供應商名稱 (20250524新增置資料庫設計表)
    private String location;   //倉庫位置
    private int safeStock; //安全庫存量  (20250524新增置資料庫設計表)
    private boolean isFoodAddtives = false; //是否為食品添加劑
    private boolean isFoodAllergen = false; //是否為過敏原
    private boolean isOutOfDate = false;    //是否過期

    private Integer effectiveDate;       //有效日期  不為0因此設定為Integer，沒有輸入為null

}
