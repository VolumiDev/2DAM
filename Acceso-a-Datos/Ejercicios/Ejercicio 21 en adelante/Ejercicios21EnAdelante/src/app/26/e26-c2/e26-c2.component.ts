import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'e26-c2',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './e26-c2.component.html',
  styleUrl: './e26-c2.component.css'
})
export class E26C2Component {


  @Output()
  notificarSize = new EventEmitter<number>();

  @Input()
  array: number[] = [];
  impares: number[] = [];
  visible: boolean = false;


  mostrarImpares(){
    this.array.forEach((n) => {
      if(n % 2 !== 0){
        this.impares.push(n);
      }
    });
    this.visible = true;
    this.notificarSize.emit(this.impares.length)
  }
}
