package com.inventorsoft.todo.list.core.repository;

import com.inventorsoft.todo.list.core.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long> {

    void deleteByIdIn(@Param("ids") List<Long> ids);
}
