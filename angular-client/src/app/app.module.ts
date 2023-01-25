import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WarehouseListComponent } from './components/warehouse-list/warehouse-list.component';
import { HomeComponent } from './views/home/home.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import  {HttpClientModule} from '@angular/common/http';
import { EditWarehouseComponent } from './components/edit-warehouse/edit-warehouse.component';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CreateWarehouseComponent } from './components/create-warehouse/create-warehouse.component';
import { RackComponent } from './components/rack/rack.component';
@NgModule({
  declarations: [
    AppComponent,
    WarehouseListComponent,
    HomeComponent,
    EditWarehouseComponent,
    CreateWarehouseComponent,
    RackComponent
  ],
  imports: [
    FormsModule,
    ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    CommonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
