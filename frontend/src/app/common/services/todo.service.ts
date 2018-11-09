import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { TodoDto } from '../models/todo-dto';

@Injectable({
    providedIn: 'root'
})
export class TodoService {
    getTodoList(): Observable<TodoDto[]> {
        return this.http.get<TodoDto[]>('/todos');
    }

    createTodo(todo: TodoDto) {
        return this.http.post('/todos', todo);
    }

    editTodo(id, todo: TodoDto) {
        return this.http.put(`/todos/${id}`, todo);
    }

    deleteTodo(ids: number[]) {
        return this.http.request('delete', `/todos`, {body: {ids}});
    }

    constructor(private http: HttpClient) {
    }
}
