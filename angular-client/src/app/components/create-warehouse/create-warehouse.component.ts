import { Component, EventEmitter, Output } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Warehouses } from 'src/app/models/entities/Warehouses';
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-create-warehouse',
  templateUrl: './create-warehouse.component.html',
  styleUrls: ['./create-warehouse.component.scss']
})
export class CreateWarehouseComponent {
  public model: Warehouses = new Warehouses();

  constructor(public activeModal: NgbActiveModal) { }

  public save(): void {
    this.activeModal.close(this.model);
  }

  public dismiss(): void {
    this.activeModal.dismiss('dismiss');
  }
}
