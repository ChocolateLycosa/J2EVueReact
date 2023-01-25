import { AfterContentChecked, AfterContentInit, AfterViewInit, ChangeDetectorRef, Component, HostListener, NgZone, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbModal, NgbModalConfig } from '@ng-bootstrap/ng-bootstrap';
import { Racks } from 'src/app/models/entities/Racks';
import { Warehouses } from 'src/app/models/entities/Warehouses';
import { RacksService } from 'src/app/services/racks/racks.service';
import { WarehousesService } from 'src/app/services/warehouses/warehouses.service';
import { RackComponent } from '../rack/rack.component';

@Component({
  selector: 'app-edit-warehouse',
  templateUrl: './edit-warehouse.component.html',
  styleUrls: ['./edit-warehouse.component.scss'],
  providers: [WarehousesService, RacksService]
})
export class EditWarehouseComponent implements OnInit {

  public model: Warehouses = new Warehouses();
  public rackList: Racks[] = [];

  constructor(private zone:NgZone, private warehouseService: WarehousesService, private rackService: RacksService, private route: ActivatedRoute, private config: NgbModalConfig, private modalService: NgbModal, private router: Router) { }


  ngOnInit(): void {
    this.route.params
      .subscribe(params => {
        this.model.id = params["id"];
        this.load();
      })
  }

  public load(): void {
    this.warehouseService
      .get(this.model.id)
      .subscribe((res: Warehouses) => {
        this.model = res;
        this.loadRacks();
      });
  }

  public loadRacks(): void {
    this.rackService.getByWarehouse(this.model.id).subscribe((res: Racks[]) => {
      this.rackList = res;
    })
  }

  public save(): void {
    this.warehouseService.put(this.model)
    .subscribe((res: Warehouses) => this.router.navigate([""]))
  }

  public openWarehouseModal(): void {
    if (this.rackList.length >= this.model.size) {
      alert("El Almacén es lleno");
    }
    else {
      const ref = this.modalService.open(RackComponent);
      ref.componentInstance.family = this.model.family;
      ref.componentInstance.model.warehouseId = this.model.id;
      ref.result
        .then((result: Racks) => {
          this.rackService.post(result).subscribe(() => {
            this.load();
          });
        })
        .catch(reason => console.log(reason));
    }
  }

  public get cannotAdd(): boolean {
    return (this.rackList.length > this.model.size);
  }

  public delete(id: number): void {
    this.rackService.delete(id)
    .subscribe(() => this.load())
  }




}
