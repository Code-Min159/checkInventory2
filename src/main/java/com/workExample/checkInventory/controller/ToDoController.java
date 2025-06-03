package com.workExample.checkInventory.controller;


import com.workExample.checkInventory.dataObject.ApiResponse;
import com.workExample.checkInventory.dataObject.ToDo;
import com.workExample.checkInventory.server.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

//    // create category 新增類別(工作、日常)
//    public DailyToDo newCategory(DailyToDo request) {
//
//    }


    //新增 ok
    @PostMapping("api/addToDo")
    public ApiResponse<ToDo> addToDo(@RequestBody ToDo request) {
        final ApiResponse<ToDo> response = new ApiResponse<>();
        try {
            ToDo newToDo = toDoService.addToDo(request.getName(), request.getIsCompleted());
            response.setData(newToDo);
            response.setStasus(HttpStatusCode.valueOf(200));
            response.setMessage("ToDo added successfully");
            return response;
        } catch (Exception e) {
            response.setStasus(HttpStatusCode.valueOf(500));
            response.setMessage(e.getMessage());
        }
        return response;
    }
    //刪除 ok
    @DeleteMapping("api/deleteToDo/{id}")
    public ApiResponse<String> deleteToDo(@PathVariable long id) {
        final ApiResponse<String> response = new ApiResponse<>();
        try {

            toDoService.deleteToDo(id);
            response.setData("ToDo deleted successfully");
            response.setStasus(HttpStatusCode.valueOf(200));
            return response;
        } catch (Exception e) {
            response.setStasus(HttpStatusCode.valueOf(500));
            response.setMessage(e.getMessage());
        }
        return response;
    }

    //更新 ok
    @PutMapping("api/updateToDo/{id}")
    public ApiResponse<ToDo> updateToDo(@PathVariable("id") long id, @RequestBody ToDo request) {
        final ApiResponse<ToDo> response = new ApiResponse<>();
        try {
            ToDo updatedToDo = toDoService.updateToDo(id, request.getName(), request.getIsCompleted());
            response.setData(updatedToDo);
            response.setStasus(HttpStatusCode.valueOf(200));
            response.setMessage("ToDo updated successfully");
            return response;
        } catch (Exception e) {
            response.setStasus(HttpStatusCode.valueOf(500));
            response.setMessage(e.getMessage());
        }
        return response;
    }

    //查詢 ok
    @GetMapping("api/getAllToDos")
    public ApiResponse<List<ToDo>> getAllToDos() {
        final ApiResponse<List<ToDo>> response = new ApiResponse<>();
        try {
            List<ToDo> allToDos = toDoService.getAllToDos();
            response.setData(allToDos);
            response.setStasus(HttpStatusCode.valueOf(200));
            response.setMessage("ToDos retrieved successfully");
            return response;
        } catch (Exception e) {
            response.setStasus(HttpStatusCode.valueOf(500));
            response.setMessage(e.getMessage());
        }
        return response;
    }


}
