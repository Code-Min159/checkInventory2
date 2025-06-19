package com.workExample.checkInventory.service;

import com.workExample.checkInventory.dao.ToDoMapper;
import com.workExample.checkInventory.dataObject.ToDo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    private final ToDoMapper todoMapper;

    public ToDoService(ToDoMapper todoMapper) {
        this.todoMapper = todoMapper;
    }

    // 新增ToDo
    public ToDo addToDo(String name, Boolean isCompleted, Integer category) {
        // 1. 檢查類別是否存在
        if (category == null) {
            throw new IllegalArgumentException("ToDo category does not exist");
        }
        // 2. 如果不存在，則新增類別
        // 3. 新增ToDo到對應的類別中

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("ToDo name cannot be null or empty");
        }
        ToDo newToDo = new ToDo();
        newToDo.setName(name);
        newToDo.setIsCompleted(isCompleted != null ? isCompleted : false);
        newToDo.setCategory(category);
        todoMapper.addToDo(newToDo);
        // 這裡可以添加邏輯來保存到數據庫或其他存儲系統
        return newToDo;

    }

    //刪除
    public void deleteToDo(long id) {
        // 這裡可以添加邏輯來刪除ToDo
        if (checkId(id) == null) {
            throw new IllegalArgumentException("ToDo with id " + id + " does not exist");
        }
        todoMapper.deleteToDo((int) id);
    }

    // 檢查ToDo是否存在
    private ToDo checkId(long id) {
        ToDo toDo = todoMapper.getToDoById((int) id);
        if (toDo == null) {
            return null;
        }
        return toDo;
    }

    //update
    public ToDo updateToDo(long id, String name, Boolean isCompleted, Integer category) {
        ToDo existingToDo = checkId(id);
        if (existingToDo == null) {
            throw new IllegalArgumentException("ToDo with id " + id + " does not exist");
        }
        existingToDo.setId(existingToDo.getId()); // 確保ID不變
        if (name != null && !name.isEmpty()) {
            existingToDo.setName(name);
        }
        if (isCompleted != null) {
            existingToDo.setIsCompleted(isCompleted);
        }
        if (category != null) {
            existingToDo.setCategory(category);
        }
        todoMapper.updateToDo(existingToDo);
        System.out.println("Updated ToDo: " + existingToDo);
        return existingToDo;
    }
    // 查詢
    public List<ToDo> getAllToDos() {
        List<ToDo> allToDos = todoMapper.getAllToDos();
        if (allToDos == null || allToDos.isEmpty()) {
            throw new IllegalArgumentException("No ToDos found");
        }
        return allToDos;
    }

    // 查詢-類別
    public List<ToDo> getToDosWithCategory(Integer category) {
        List<ToDo> getToDos = todoMapper.getToDosWithCategory(category);
        if(getToDos == null){
            return null;
        }
        return getToDos;
    }

    // resetToDoStatus
    public String resetAllToDoStatus() {
        List<ToDo> allToDos = todoMapper.getAllToDos();
        if (allToDos == null || allToDos.isEmpty()) {
            return "No ToDos to reset";
        }
        for (ToDo toDo : allToDos) {
            toDo.setIsCompleted(false);
            todoMapper.updateToDo(toDo);
        }
        return "All ToDos have been reset to incomplete status";
    }




}
