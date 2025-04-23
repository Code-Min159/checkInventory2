package com.workExample.checkInventory.dataObject;

import lombok.Data;
import org.springframework.http.HttpStatusCode;

@Data
public class ApiResponse<T> {

    private HttpStatusCode stasus;
    private String message;
    private T data;





}
