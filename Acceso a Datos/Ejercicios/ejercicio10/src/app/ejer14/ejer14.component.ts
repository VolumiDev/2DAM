import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Izq14Component } from '../izq14/izq14.component';
import { Der14Component } from '../der14/der14.component';

@Component({
  selector: 'app-ejer14',
  standalone: true,
  imports: [FormsModule, CommonModule, Izq14Component, Der14Component],
  templateUrl: './ejer14.component.html',
  styleUrl: './ejer14.component.css'
})
export class Ejer14Component {
  vectorRecibido: string[] = []
  
  recibirVector()
}
