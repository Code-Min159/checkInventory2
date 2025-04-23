package com.workExample.checkInventory.server;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {


    /***
     * read outside file
     * @return
     */
//    public File readFile(String fileName){
//        FileReader fr = null;
//        try {
//            fr = new FileReader(fileName); //用Char、String方式讀取(讀取文字檔)
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        BufferedReader br = new BufferedReader(fr);
//        String tmp = null;
//
//        try {
//            while (((tmp = br.readLine()) != null)) {
//                System.out.println(tmp);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                br.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public File writeFile(String fileName){
//        List<String> list = new ArrayList<String>();
//        list.add("Java的I/O");
//        list.add("讀取檔案內容");
//        list.add("寫入檔案內容");
//        try {
//            FileWriter fw = new FileWriter(fileName);
//            BufferedWriter bw = new BufferedWriter(fw);
//
//            for (String s: list){
//                bw.write(s);    // 寫入資料
//                bw.newLine();   // 新增一行
//            }
//            bw.flush(); // 把記憶體資料寫進去
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }



}
