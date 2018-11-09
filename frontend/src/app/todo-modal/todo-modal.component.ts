import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TodoService } from '../common/services/todo.service';
import { first } from 'rxjs/operators';
import { TodoDto } from '../common/models/todo-dto';
import { TodoManager } from '../utils/todo-manager';

@Component({
    selector   : 'app-todo-modal',
    templateUrl: './todo-modal.component.html',
    styleUrls  : ['./todo-modal.component.scss']
})
export class TodoModalComponent {

    now = new Date();

    isEditMode: boolean = false;

    todoForm: FormGroup = this.fb.group({
        title      : ['', [Validators.required, Validators.maxLength(100)]],
        description: ['', [Validators.required, Validators.maxLength(1000)]],
        date       : [null, [Validators.required]],
        time       : ['23:59']
    });

    constructor(public dialogRef: MatDialogRef<TodoModalComponent>,
                private fb: FormBuilder,
                private todoService: TodoService,
                @Inject(MAT_DIALOG_DATA) public data: { todo: TodoDto }) {
        this.isEditMode = !!this.data.todo;

        if (this.isEditMode) {
            const todo = TodoManager.dtoToModel(data.todo);
            this.todoForm.patchValue({...todo});
        }
    }

    closeModal(isOk: boolean) {
        this.dialogRef.close(isOk);
    }

    createTodo(todo: TodoDto) {
        this.todoService.createTodo(todo)
            .pipe(first())
            .subscribe(() => {
                this.closeModal(true);
            });
    }

    updateTodo(todo: TodoDto) {
        this.todoService.editTodo(this.data.todo.id, todo)
            .pipe(first())
            .subscribe(() => {
                this.closeModal(true);
            });
    }

    onSubmit() {
        const payload: TodoDto = TodoManager.modelToDto(this.todoForm.value);
        this.isEditMode
            ? this.updateTodo(payload)
            : this.createTodo(payload);
    }

}
