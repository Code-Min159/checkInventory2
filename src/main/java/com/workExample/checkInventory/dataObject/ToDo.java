package com.workExample.checkInventory.dataObject;

import lombok.Data;

import java.util.List;

@Data
public class ToDo {
    private long id;        //編號(自動產生)
    private String name;    //名稱
    private Boolean isCompleted = false; //是否完成(完成劃一條線)
    private Integer category; //類別(0:出貨、1:進貨)
}



