export class TodoDto {
    id?: number;
    title: string;
    description: string;
    eventTime: string;

    constructor(todo?: TodoDto) {
        todo && Object.keys(todo).forEach(key => this[key] = todo[key]);
    }
}