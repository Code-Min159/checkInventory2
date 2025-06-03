package com.workExample.checkInventory.dataObject;

import lombok.Data;

import java.util.List;

@Data
public class ToDo {
    private long id;        //編號(自動產生)
    private String name;    //名稱
    private Boolean isCompleted = false; //是否完成(完成劃一條線)
//    private String category; //類別(是工作或是日常)
//    private List<ToDo> dailyToDos; //(由類別決定是工作或是日常的ToDo列表)
}
