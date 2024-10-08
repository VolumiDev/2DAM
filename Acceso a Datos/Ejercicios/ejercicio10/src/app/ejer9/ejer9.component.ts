import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-ejer9',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './ejer9.component.html',
  styleUrl: './ejer9.component.css'
})
export class Ejer9Component {

  valor: string = "888";


  comparar(valor: string):string {
    if(valor === "888"){
      return "Iguales";
    }else {
      return "Distintos"
    }
  }
}
