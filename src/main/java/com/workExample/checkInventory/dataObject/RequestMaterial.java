package com.workExample.checkInventory.dataObject;


import lombok.Data;

@Data
public class RequestMaterial {
    private int materialId;
    private String materialName;    //原料名稱
    private Integer materiaEffectiveDate;       //有效日期
    private double useWeight;  //重量規格
    private double standard_usage;  //標準用量
    private double the_amount_of_this_time; //本次使用量
    private String location;        //存放庫位
}
