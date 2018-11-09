export class TodoModel {
    id?: number;
    title: string;
    description: string;
    date: Date;
    time: string;

    constructor(todo?: TodoModel) {
        todo && Object.keys(todo).forEach(key => this[key] = todo[key]);
    }

}