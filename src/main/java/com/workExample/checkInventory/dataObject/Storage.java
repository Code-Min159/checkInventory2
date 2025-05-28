package com.workExample.checkInventory.dataObject;

import lombok.Data;

@Data
//倉庫名稱
public class Storage {
    private String id; //倉庫編號
    private String name; //倉庫名稱
    private String area; //倉庫區域 (一個倉庫空間有分特定區域，如：A區、B區、清真專用等)
    private String description; //倉庫描述(如：B區:清真專用等)
    private int rack; //料架(0-10)
    private int layer; //層數(0-3)
    private int pallet; //板數(0-100)
    private String factory; //倉庫廠別(Fab1、Fab2等)
    private String status; //倉庫狀態(D:停用、A:可用、F:維修中、O:已滿)
    private int storageType; //倉庫類型 (如：0:冷凍、1:冷藏、2:常溫、3:恆溫恆濕)
    private int maxSpace; //最大空間

    public Storage(String id, String name, String area, String description, int rack, int layer, int pallet, String factory, String status, int storageType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.description = description;
        this.rack = rack;
        this.layer = layer;
        this.pallet = pallet;
        this.factory = factory;
        this.status = status;
        this.storageType = storageType;
        this.maxSpace = rack * layer * pallet; //計算最大空間

    }
}
