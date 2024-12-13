import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-ejer8',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './ejer8.component.html',
  styleUrl: './ejer8.component.css'
})
export class Ejer8Component {

  numeros: Array<number> = [1, 5, 6, 3, 9, 8, 8, 1];
  valor: number = 0;

  comparar(): void{
    console.log(this.valor);
  } 
}
