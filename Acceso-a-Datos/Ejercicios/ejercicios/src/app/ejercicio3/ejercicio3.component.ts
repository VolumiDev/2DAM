import { Component } from '@angular/core';
import { Perro } from '../Models/perro';
@Component({
  selector: 'app-ejercicio3',
  standalone: true,
  imports: [],
  templateUrl: './ejercicio3.component.html',
  styleUrl: './ejercicio3.component.css'
})
export class Ejercicio3Component {

p1: Perro = new Perro();

p2: Perro = new Perro(123, "Otto", "Golden", 37, true);
}