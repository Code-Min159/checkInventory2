package com.workExample.checkInventory.dataObject;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Product {

    private int productId;
    private String productName;
    private Integer productEffectiveDate;
    private boolean isOutOfDate = false;
    private double expectedOutputUnit;      //預計生產槽數
    private String location;
    private double weight;
    private ArrayList<Material> RequestMaterial; //原料清單 //

}
