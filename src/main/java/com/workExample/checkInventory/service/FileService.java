package com.workExample.checkInventory.service;

import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class FileService {


    /***
     * read outside file
     * @return
     */
    public File readFile(String fileName) {
        FileReader fr = null;
        try {
            fr = new FileReader(fileName); //用Char、String方式讀取(讀取文字檔)
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);
        String tmp = null;

        try {
            while (((tmp = br.readLine()) != null)) {
                System.out.println(tmp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
