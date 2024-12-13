import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-ejer11',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './ejer11.component.html',
  styleUrl: './ejer11.component.css'
})
export class Ejer11Component {

  numeros: Array<number> = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
  tipo: string ="par";
}
