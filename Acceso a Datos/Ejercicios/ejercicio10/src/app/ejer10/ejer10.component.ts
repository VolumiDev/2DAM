import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-ejer10',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './ejer10.component.html',
  styleUrl: './ejer10.component.css'
})
export class Ejer10Component {

  numeros: Array<number> = [1, 3, 5, 7, 9];

  delReves: Array<number> = this.numeros.slice().reverse();
}
