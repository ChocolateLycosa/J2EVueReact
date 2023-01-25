import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Racks } from 'src/app/models/entities/Racks';
import { HttpService } from '../http/HttpService';

@Injectable({
  providedIn: 'root'
})
export class RacksService extends HttpService<Racks, number> {

  constructor(http: HttpClient) {
    super(http, "racks");
  }


  public getByWarehouse(warehouseId: number): Observable<Racks[]>{
    return this.http.get<Racks[]>(`${this.url}/warehouse/${warehouseId}`)
  }
}
