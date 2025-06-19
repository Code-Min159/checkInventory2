package com.workExample.checkInventory.service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import org.junit.jupiter.api.Test;

public class TestExcelService {

    @Test
    public void simpleRead() {
        // 文件的地址 "C:\Users\USER\Desktop\31商品原料列表(1).xlsx"
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
//        EasyExcel.read(fileName, DemoData.class, new ReadListener() {
//            @Override
//            public void invoke(Object o, AnalysisContext analysisContext) {
//
//            }
//
//            @Override
//            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
//
//            }
//        }
    }

}
