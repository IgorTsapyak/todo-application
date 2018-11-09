package com.inventorsoft.todo.list.core.repository;

import com.inventorsoft.todo.list.core.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository level for {@link ToDoItem}
 */
public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long> {

    /**
     * Deletes the range of the items form the DB
     * @param ids unique items identifiers
     */
    void deleteByIdIn(@Param("ids") List<Long> ids);
}
