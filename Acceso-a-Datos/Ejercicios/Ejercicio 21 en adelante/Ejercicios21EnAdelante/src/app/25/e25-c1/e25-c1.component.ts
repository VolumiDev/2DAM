import { Component, input } from '@angular/core';
import { E25C2Component } from "../e25-c2/e25-c2.component";

@Component({
  selector: 'e25-c1',
  standalone: true,
  imports: [E25C2Component],
  templateUrl: './e25-c1.component.html',
  styleUrl: './e25-c1.component.css'
})
export class E25C1Component {

  array1: number[] = [17, 23, 12, 4, 5, 8, 13];
  array3: number[] = [];

  recibeArray(array2:number[]){
    this.array1.forEach((n) =>{
      for (let i = 0; i < array2.length; i++) {
        if (n === array2[i]){
          this.array3.push(n)
        }
      }
    });
  }
}
