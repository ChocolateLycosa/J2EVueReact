import { Component, Input } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Racks } from 'src/app/models/entities/Racks';

@Component({
  selector: 'app-rack',
  templateUrl: './rack.component.html',
  styleUrls: ['./rack.component.scss']
})
export class RackComponent {
  public model: Racks =  new Racks();
  @Input() public family: "EST" | "ROB" = "EST";

  constructor(public activeModal: NgbActiveModal) { }

  public save(): void {
    this.activeModal.close(this.model);
  }

  public dismiss(): void {
    this.activeModal.dismiss('dismiss');
  }
}
