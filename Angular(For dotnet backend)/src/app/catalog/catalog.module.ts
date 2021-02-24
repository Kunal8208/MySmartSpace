import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListProductsComponent } from './list-products/list-products.component';
import { ProductlistComponent } from './productlist/productlist.component';



@NgModule({
  declarations: [ListProductsComponent, ProductlistComponent],
  imports: [
    CommonModule
  ]
})
export class CatalogModule { }
