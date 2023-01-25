import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditWarehouseComponent } from './components/edit-warehouse/edit-warehouse.component';
import { WarehouseListComponent } from './components/warehouse-list/warehouse-list.component';

const routes: Routes = [
  {
    path: '',
    component: WarehouseListComponent
  },
  {
    path:'warehouse/:id/:edit',
    component: EditWarehouseComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
