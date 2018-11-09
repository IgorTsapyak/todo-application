package com.inventorsoft.todo.list.core.service.impl;

import com.inventorsoft.todo.list.core.model.ToDoItem;
import com.inventorsoft.todo.list.core.repository.ToDoItemRepository;
import com.inventorsoft.todo.list.core.service.ToDoItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
@RequiredArgsConstructor
public class ToDoItemServiceImpl implements ToDoItemService {

    private final ToDoItemRepository toDoItemRepository;

    @Transactional
    @Override
    public ToDoItem save(ToDoItem toDoItem) {
        return toDoItemRepository.save(toDoItem);
    }

    @Transactional
    @Override
    public ToDoItem update(ToDoItem toDoItem, Long id) {
        toDoItem.setId(id);
        return toDoItemRepository.save(toDoItem);
    }

    @Transactional
    @Override
    public void delete(List<Long> ids) {
        toDoItemRepository.deleteByIdIn(ids);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ToDoItem> get() {
        return toDoItemRepository.findAll();
    }
}
