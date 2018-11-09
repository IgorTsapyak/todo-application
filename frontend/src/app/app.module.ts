import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { HttpInterceptorService } from './utils/http-interceptor.service';
import {
    MatButtonModule,
    MatCheckboxModule,
    MatDatepickerModule,
    MatDialogModule,
    MatExpansionModule,
    MatIconModule,
    MatInputModule, MatNativeDateModule
} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { TodoModalComponent } from './todo-modal/todo-modal.component';
import { ReactiveFormsModule } from '@angular/forms';
import { DatePipe } from '@angular/common';

@NgModule({
    declarations   : [
        AppComponent,
        TodoModalComponent
    ],
    imports        : [
        BrowserModule,
        HttpClientModule,
        BrowserAnimationsModule,
        MatExpansionModule,
        MatInputModule,
        MatIconModule,
        MatButtonModule,
        MatDialogModule,
        MatCheckboxModule,
        MatDatepickerModule,
        MatNativeDateModule,
        ReactiveFormsModule
    ],
    entryComponents: [TodoModalComponent],
    providers      : [
        DatePipe,
        {
            provide : HTTP_INTERCEPTORS,
            multi   : true,
            useClass: HttpInterceptorService
        }
    ],
    bootstrap      : [AppComponent]
})
export class AppModule {}
