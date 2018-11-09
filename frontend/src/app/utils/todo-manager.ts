import { TodoModel } from '../common/models/todo-model';
import { TodoDto } from '../common/models/todo-dto';
import { DatePipe } from '@angular/common';

export class TodoManager {
    static modelToDto({title, description, date, time}: TodoModel): TodoDto {
        const datePipe  = new DatePipe('en-US'),
              eventTime = datePipe.transform(new Date(date), 'MM/dd/yyyy') + ' ' + time;

        return {title, description, eventTime};
    }

    static dtoToModel({title, eventTime, description}: TodoDto): TodoModel {
        const [date, time] = eventTime.split(' ');
        return {
            title, description, time,
            date: new Date(date)
        };
    }
}