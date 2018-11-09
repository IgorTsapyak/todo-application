import { Component, OnInit } from '@angular/core';
import { TodoService } from './common/services/todo.service';
import { first } from 'rxjs/operators';
import { MatCheckboxChange, MatDialog } from '@angular/material';
import { TodoModalComponent } from './todo-modal/todo-modal.component';
import { TodoDto } from './common/models/todo-dto';

@Component({
    selector   : 'app-root',
    templateUrl: './app.component.html',
    styleUrls  : ['./app.component.scss']
})
export class AppComponent implements OnInit {
    todos: TodoDto[]       = [];
    checkedTodos: number[] = [];

    constructor(private todoService: TodoService, public dialog: MatDialog) {
    }

    onCheckAll(event: MatCheckboxChange) {
        this.checkedTodos = event.checked
            ? this.todos.map(todo => todo.id)
            : [];
    }

    get isAllChecked(): boolean {
        return this.checkedTodos.length && this.checkedTodos.length === this.todos.length;
    }

    onTodoCheck(event: MatCheckboxChange, todo) {
        if (event.checked) {
            this.checkedTodos.push(todo.id);
        } else {
            const targetTodoIdIndex = this.checkedTodos.indexOf(todo.id);
            if (~targetTodoIdIndex) {
                this.checkedTodos.splice(targetTodoIdIndex, 1);
            }
        }
    }

    isTodoChecked(id: number): boolean {
        return this.checkedTodos.indexOf(id) !== -1;
    }

    isAnyTodoChecked(): boolean {
        return !this.checkedTodos.length;
    }

    deleteTodo() {
        this.todoService.deleteTodo(this.checkedTodos)
            .pipe(first())
            .subscribe(() => this.getTodoList());
    }

    getTodoList() {
        this.todoService.getTodoList()
            .pipe(first())
            .subscribe((todos: TodoDto[]) => {
                this.checkedTodos = [];
                this.todos        = todos;
            });
    }

    openDialog(todo?: TodoDto): void {
        const dialogRef = this.dialog.open(TodoModalComponent, {
            data: {todo}
        });

        dialogRef.afterClosed().subscribe(isOk => {
            if (isOk) {
                this.getTodoList();
            }
            console.log('The dialog was closed');
        });
    }

    ngOnInit() {
        this.getTodoList();
    }

    openEdit(event, todo) {
        event.preventDefault();
        event.stopPropagation();
        this.openDialog(todo);
    }
}
