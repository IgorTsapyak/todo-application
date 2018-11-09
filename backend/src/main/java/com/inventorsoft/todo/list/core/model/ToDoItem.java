package com.inventorsoft.todo.list.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.inventorsoft.todo.list.common.Validation.ValidEventTime;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * POJO with the data which is related to the to do items.
 */
@Getter
@Setter
@Entity
public class ToDoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Length(max = 50, message = "The title should be less than 100 characters.")
    private String title;

    @NotBlank
    @Length(max = 1000, message = "The description should be less than 1000 characters.")
    private String description;

    @ValidEventTime
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime eventTime;


}
