import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Warehouses } from 'src/app/models/entities/Warehouses';
import { HttpService } from '../http/HttpService';

@Injectable({
  providedIn: 'root'
})
export class WarehousesService extends HttpService<Warehouses, number>  {

  constructor(http: HttpClient) {
    super(http, "warehouses");
   }
}
