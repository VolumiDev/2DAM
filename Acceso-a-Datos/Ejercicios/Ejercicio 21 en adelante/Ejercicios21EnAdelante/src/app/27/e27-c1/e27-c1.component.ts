import { Component } from '@angular/core';
import { E27C2Component } from "../e27-c2/e27-c2.component";
import { CommonModule } from '@angular/common';

@Component({
  selector: 'e27-c1',
  standalone: true,
  imports: [E27C2Component, CommonModule],
  templateUrl: './e27-c1.component.html',
  styleUrl: './e27-c1.component.css'
})
export class E27C1Component {

  array1: number[] = [1,5,3, 6,7,8,0];
  datos: number[] = [];
  visible: boolean = false;

  recibeDatos(arr: number[]){
    this.datos = arr;
    this.visible = true;
    console.log(this.datos)
  }
}
