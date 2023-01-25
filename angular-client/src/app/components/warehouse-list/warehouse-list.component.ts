import { Component, OnInit } from '@angular/core';
import { NgbModal, NgbModalConfig, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { Warehouses } from 'src/app/models/entities/Warehouses';
import { WarehousesService } from 'src/app/services/warehouses/warehouses.service';
import { CreateWarehouseComponent } from '../create-warehouse/create-warehouse.component';

@Component({
  selector: 'app-warehouse-list',
  templateUrl: './warehouse-list.component.html',
  styleUrls: ['./warehouse-list.component.scss'],
  providers: [WarehousesService]
})
export class WarehouseListComponent implements OnInit {
  public list: Warehouses[] = [];

  constructor(private warehousesService: WarehousesService, private config: NgbModalConfig, private modalService: NgbModal) {}

  ngOnInit(): void {
    this.load();
  }


  public openWarehouseModal(): void {
    this.modalService.open(CreateWarehouseComponent)
    .result
    .then((result: Warehouses) => {
      console.log(result)
      this.warehousesService.post(result).subscribe(() => {
        this.load();
      });
    })
    .catch(reason => console.log("dismissed"));
  }



  public deleteWarehouse(evt: Event, id: number): void {
    evt.preventDefault();
    evt.stopPropagation();
    this.warehousesService
      .delete(id)
      .subscribe(result => this.load());
  }

  public load(): void {
    this.warehousesService
      .getAll()
      .subscribe(result => {
        this.list = result;
      });
  }

}
