package com.workExample.checkInventory.dataObject;

import lombok.Data;

@Data
public class DailyToDo {
    private int id;        //編號
    private String name;    //名稱
    private Boolean isCompleted; //是否完成
}
