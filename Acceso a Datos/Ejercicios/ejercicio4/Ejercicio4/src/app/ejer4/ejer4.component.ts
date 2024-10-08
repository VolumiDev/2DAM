import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import {Persona } from '../models/persona';

@Component({
  selector: 'app-ejer4',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './ejer4.component.html',
  styleUrl: './ejer4.component.css'
})
export class Ejer4Component {

  p1:Persona;
  p2:Persona;
  constructor(){
    this.p1 = new Persona("Diego", "Martin Garcia", 35);
    this.p2 = new Persona("Laura", "Gonzalez Perez", 35);
  }

}
