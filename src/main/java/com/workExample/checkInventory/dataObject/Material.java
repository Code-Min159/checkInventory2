package com.workExample.checkInventory.dataObject;

import lombok.Data;

@Data
public class Material {
    private String id;        //原料編號  1個英文字母(B:原料、C:物料、D:半成品)+11碼數字  EX: B40206000001
    private String name;    //原料名稱
    private double weight;  //重量規格(只有新增需要)
    private Integer effectiveDate;       //有效日期  不為0因此設定為Integer，沒有輸入為null
    private boolean isOutOfDate = false;    //是否過期
    private boolean isFoodAddtives = false; //是否為食品添加劑
    private boolean isFoodAllergen = false; //是否為過敏原
    private String location;   //原料存放庫位
    private String description; //備註   (20250415新增置資料庫設計表)
    
}
