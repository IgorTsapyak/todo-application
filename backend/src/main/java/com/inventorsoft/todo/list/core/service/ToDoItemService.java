package com.inventorsoft.todo.list.core.service;

import com.inventorsoft.todo.list.core.model.ToDoItem;

import java.util.List;

/**
 * Service layer for CRUD operations with {@link ToDoItem}
 */
public interface ToDoItemService {

    ToDoItem save(ToDoItem todo);

    ToDoItem update(ToDoItem todo, Long id);

    void delete(List<Long> ids);

    List<ToDoItem> get();

}
