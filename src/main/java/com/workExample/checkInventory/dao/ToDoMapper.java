package com.workExample.checkInventory.dao;

import com.workExample.checkInventory.dataObject.ToDo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ToDoMapper {

    // 這裡定義簡單的ToDo相關的數據庫操作方法，例如新增、更新、刪除等
    @Insert("INSERT INTO todo (name, is_completed, category) " +
            "VALUES ( #{name}, #{isCompleted}, #{category})")
    @Options(useGeneratedKeys = true, keyProperty = "id")    //系統自動設定ID
    void addToDo(ToDo toDo);


   @Update("UPDATE todo SET name = #{name}, is_completed = #{isCompleted}, category = #{category} WHERE id = #{id}")
    ToDo updateToDo(ToDo toDo);


    @Delete("DELETE FROM todo WHERE id = #{id}")
    void deleteToDo(int id);


    @Select("SELECT * FROM todo")
    List<ToDo> getAllToDos();

    @Select("SELECT * FROM todo WHERE id = #{id}")
    ToDo getToDoById(int id);

    @Select("SELECT * FROM todo WHERE category = #{category}")
    List<ToDo> getToDosWithCategory(Integer category);

}
