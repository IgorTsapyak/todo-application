package com.inventorsoft.todo.list.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * Data wrapper for a collection of an id`s of the {@link ToDoItem} which are provided to delete multiple items.
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DeleteToDosWrapper {

    @NotEmpty
    private List<Long> ids;
}
