import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { C3Component } from "../c3/c3.component";

@Component({
  selector: 'app-c2',
  standalone: true,
  imports: [CommonModule, C3Component],
  templateUrl: './c2.component.html',
  styleUrl: './c2.component.css'
})
export class C2Component {
  title: string = 'C2';
  mandaBoolean: boolean = false;

  @Input()
  numeroC1!: number ;

  isPar(){
    if(this.numeroC1 %2 ==0){
      this.mandaBoolean = true
    }else{
      this.mandaBoolean = false
    }
  }
}
