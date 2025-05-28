package com.workExample.checkInventory.controller;

import com.workExample.checkInventory.dataObject.ApiResponse;
import com.workExample.checkInventory.dataObject.Material;
import com.workExample.checkInventory.server.FileService;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.Objects;

@RestController
public class FileController {

    private FileService fileService;

    /***
     *
     * @return
     */
    @PostMapping("api/readFile")
    public String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
    @PostMapping("api/readFileB")
    public void readFile(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename()); // 寫出檔案名稱

        BufferedInputStream is = new BufferedInputStream(file.getInputStream()); // 建立檔案輸入串流
        ByteArrayOutputStream os = new ByteArrayOutputStream(); // 建立ByteArray輸出串流
        int result;
        while((result = is.read()) != -1) { // 從輸入串流讀取資料
            os.write((byte) result); // 將讀取的資料寫出至輸出串流
        }

        System.out.println(os.toString("UTF-8")); // 將輸出串流印出
        System.out.println(os.toString(result)); // 將輸出串流印出

    }
//    public String readFile(@RequestParam("file") MultipartFile file) throws IOException  {
//        ApiResponse<List<Material>> response = new ApiResponse<>();
//        try{
//            //判斷有沒有檔案傳入
//            if(Objects.isNull(file)){
//                response.setStasus(HttpStatusCode.valueOf(400));
//                response.setMessage("file is null");
//                return "file is null";
//            }
//            File fileIsExist = fileService.readFile(file);
//            response.setData(fileIsExist);
//            response.setStasus(HttpStatusCode.valueOf(200));
//            System.out.println("read file is success");
//            return "read file is success";
//        } catch (Exception e) {
//            response.setStasus(HttpStatusCode.valueOf(500));
//            response.setMessage(e.getMessage());
//        }
//
//        System.out.println("read file is not success");
//        return "read file is not success";
//    }


}
