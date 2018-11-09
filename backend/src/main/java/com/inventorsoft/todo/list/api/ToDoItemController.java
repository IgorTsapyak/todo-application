package com.inventorsoft.todo.list.api;

import com.inventorsoft.todo.list.core.model.DeleteToDosWrapper;
import com.inventorsoft.todo.list.core.model.ToDoItem;
import com.inventorsoft.todo.list.core.service.ToDoItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/todos")
@RestController
@RequiredArgsConstructor
public class ToDoItemController {

    private final ToDoItemService toDoItemService;

    @GetMapping
    public ResponseEntity<List<ToDoItem>> get() {
        return ResponseEntity.ok(toDoItemService.get());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody ToDoItem toDoItem) {
        toDoItemService.save(toDoItem);
    }

    @PutMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@Valid @RequestBody ToDoItem toDoItem, @PathVariable Long id) {
        toDoItemService.update(toDoItem, id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestBody DeleteToDosWrapper ids) {
        toDoItemService.delete(ids.getIds());
    }
}
