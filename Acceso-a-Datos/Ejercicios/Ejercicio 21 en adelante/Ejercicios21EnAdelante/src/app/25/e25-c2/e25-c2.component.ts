import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'e25-c2',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './e25-c2.component.html',
  styleUrl: './e25-c2.component.css'
})
export class E25C2Component {

  array2: number[] = [4,8,15,12,17,6,76,34,4];
  
  @Input()
  array3: number[] = [];

  @Output()
  mandarArray = new EventEmitter<number[]>()


  comezar(){
    this.mandarArray.emit(this.array2);
  }


}
