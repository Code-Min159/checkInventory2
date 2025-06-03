package com.workExample.checkInventory.server;

import com.workExample.checkInventory.dao.ToDoMapper;
import com.workExample.checkInventory.dataObject.ToDo;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    private final ToDoMapper toDoMapper;

    public ToDoService(ToDoMapper toDoMapper){
        this.toDoMapper = toDoMapper;
    }

    // 新增ToDo
    public ToDo addToDo(String name, Boolean isCompleted) {
        // 1. 檢查類別是否存在
        // 2. 如果不存在，則新增類別
        // 3. 新增ToDo到對應的類別中

       if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("ToDo name cannot be null or empty");
        }
        ToDo newToDo = new ToDo();
        newToDo.setName(name);
        newToDo.setIsCompleted(isCompleted != null ? isCompleted : false);
        toDoMapper.addToDo(newToDo);
        // 這裡可以添加邏輯來保存到數據庫或其他存儲系統
        return newToDo;

    }

    //刪除
    public void deleteToDo(long id) {
        // 這裡可以添加邏輯來刪除ToDo
        if(checkId(id) == null) {
            throw new IllegalArgumentException("ToDo with id " + id + " does not exist");
        }
        toDoMapper.deleteToDo((int) id);
    }

    // 檢查ToDo是否存在
    private ToDo checkId(long id) {
        ToDo toDo = toDoMapper.getToDoById((int) id);
        if (toDo == null) {
            return null;
        }
        return toDo;
    }
    // 更新ToDo
    public ToDo updateToDo(long id, String name, Boolean isCompleted) {
        ToDo existingToDo = checkId(id);
        if (existingToDo == null) {
            throw new IllegalArgumentException("ToDo with id " + id + " does not exist");
        }
        if(name == null && name.isEmpty()) {
            throw new IllegalArgumentException("ToDo name cannot be null or empty");
        }
        existingToDo.setName(name);
        existingToDo.setIsCompleted(isCompleted);
        toDoMapper.updateToDo(existingToDo); // 使用addToDo方法更新
        return existingToDo;
    }

    // 查詢
    public List<ToDo> getAllToDos() {
        List<ToDo> allToDos = toDoMapper.getAllToDos();
        if (allToDos == null || allToDos.isEmpty()) {
            throw new IllegalArgumentException("No ToDos found");
        }
        return allToDos;
    }

}
