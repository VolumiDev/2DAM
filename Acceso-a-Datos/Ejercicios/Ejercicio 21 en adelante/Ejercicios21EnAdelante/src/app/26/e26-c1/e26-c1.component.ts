import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { E26C2Component } from "../e26-c2/e26-c2.component";

@Component({
  selector: 'e26-c1',
  standalone: true,
  imports: [CommonModule, E26C2Component],
  templateUrl: './e26-c1.component.html',
  styleUrl: './e26-c1.component.css'
})
export class E26C1Component {

  array1: number[] = [1,54,2,65,98,3,71,18];
  size: number = 0;

  recibeSize(n: number){
    this.size = n;
    console.log(this.size)
  }

}
