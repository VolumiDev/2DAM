import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { max } from 'rxjs';

@Component({
  selector: 'e27-c2',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './e27-c2.component.html',
  styleUrl: './e27-c2.component.css'
})
export class E27C2Component {

  @Output()
  mandaDatos = new EventEmitter<number[]>
  

  @Input()
  array1: number[] = [];
  
  array2: number[] = [3,3,5,5,5,8,9,5];
  rep: number = 0;
  maxrep: number = 0;
  maxveces: number = 0;
  datos: number[] = [];
  visible: boolean = true;

  compararNumeros(){
    this.visible = false;
    this.array1.forEach((n) => {
      this.array2.forEach(element => {
        if(n == element){
          this.rep++;
        }
      });

      if(this.rep > this.maxveces){
        this.maxveces = this.rep;
        this.maxrep = n;
      }
      this.rep = 0;
    })
    this.mandaInfo()
    this.maxrep = 0
    this.maxveces = 0;
  }

  mandaInfo(){
    this.datos.push(this.maxrep);
    this.datos.push(this.maxveces);
    this.mandaDatos.emit(this.datos)
  }

}
